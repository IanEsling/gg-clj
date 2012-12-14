(ns gg-clj.app
  (:gen-class)
  (:use [gg-clj.db :as db])
  (:use [gg-clj.mail :as mail])
  (:use [gg-clj.web :as web])
  (:use [gg-clj.core :as core])
  (:use [gg-clj.page :as page])
  (:use clojure.tools.logging)
  (:use clj-logging-config.log4j)
  (:use [compojure.core :only [defroutes GET]])
  (:use ring.middleware.reload)
  (:import [org.joda.time.format DateTimeFormat])
  (:import [org.joda.time LocalDate])
  (:require [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]))

(defn finish-positions-for-races
  "returns a function that returns a list of finishing positions for a list of races after it's been filtered by the given function"
  [f]
  (fn [races]
    (for [race (f races)]
      {:finish (:finish (first (:horses race)))
       :odds (:odds (first (:horses race)))
       :venue (:venue race)
       :time (:time race)
       :name (:name (first (:horses race)))
       :magic-number (:magic-number (first (:horses race)))}
      )))


(defn first-race-only
  "function used in composing finishing position functions.  Filters out every race except the first one."
  []
  (comp vector first))

(defn finishing-positions
  "return a function that returns a list of finishing positions for a list of races based on composing the functions given."
  [& fs]
    (finish-positions-for-races (apply comp fs)))

(defn below-magic-number-of
  "function used in composing finishing position functions.  Filters out races with a magic number greater than that given."
  [magic-number]
  (partial filter #(< (:lowest-magic-number %) magic-number)))

(defn odds-difference-less-than
  "function used in composing finishing position functions.  Filters out races with an odds difference greater than that given."
  [odds-diff]
  (partial filter #(> odds-diff (:odds-diff %))))

(defn race-day-results
  "returns results for every race day, races-f calculates the day's races (either back or lay betting) and finish-f determines which finishes we're interested in for that race day.  Optional magic number function that will be used to calculate each horse's magic number (defaults to core/magic-number) and optional odds difference function used to calculate the odds difference "
  ([races-f finish-f] (race-day-results races-f finish-f (core/magic-number-f 1 1 1 0)))
  ([races-f finish-f magic-number-f] (race-day-results races-f finish-f magic-number-f core/second-odds-difference))
  ([races-f finish-f magic-number-f odds-diff-f]
     (for [race-day (db/race-days-with-results)]
       (let [finishes (finish-f (races-f (:races (db/get-race-day (:race_date race-day))) magic-number-f))]
         {:race_date (.getTime (:race_date race-day))
          :finish (map :finish finishes)
          :finishes finishes}))))

(defn race-day-lay-results
  "take all the lay bets for all the race days from race-day-results with a function that determines which finishes we're interested in (defaults to first race only i.e. lowest magic number) and a function that's used to calculate the magic number for each horse (defaults to core/magic-number)"
  ([] (race-day-lay-results (finishing-positions (first-race-only))))
  ([finish-f] (race-day-lay-results finish-f (core/magic-number-f 1 1 1 0)))
  ([finish-f magic-number-f] (race-day-lay-results finish-f magic-number-f core/second-odds-difference))
  ([finish-f magic-number-f odds-diff-f] (race-day-results core/calculate-lay-bet-races finish-f magic-number-f odds-diff-f)))

(defn race-day-back-results
  "take all the back bets for all race days from race-day-results with a function that determines which finishes we're interested in.  Defaults to just betting on the first race (the highest magic number)"
  ([] (race-day-back-results (finishing-positions (first-race-only))))
  ([finish-f] (race-day-back-results finish-f (core/magic-number-f 1 1 1 0)))
  ([finish-f magic-number-f]
     (race-day-results core/calculate-back-bet-races finish-f magic-number-f)))

(defn running-lay-total
  "adds the points total for lay betting for the race day's finishes onto x"
  [x race-day]
  (prn (:finish race-day))
  (with-precision 5 (+ x (reduce (fn [tot finish]
                                   (+ tot (if (nil? finish) 0  (if (not= 1M (BigDecimal. finish)) 0.95M -2.0M))))
                                 0M
                                 (:finish race-day)))))

(defn running-back-total
  "adds the points total for back betting for the race day's finishes onto x"
  [x race-day]
   (with-precision 5 (+ x (reduce (fn [tot finish]
                                    (+ tot (if (not= 1M (BigDecimal. finish)) -1.0M 1.5M)))
                                 0M
                                 (:finish race-day)))))

(defn running-total
  "produces a map of race dates with a running total of results.  The running-f is called for each race day and knows how to add up the points for the finishing positions on that race day (there's a lay running f and a back betting one)"
  [race-days running-f]
  (def total (atom 0M))
  (def race-totals (atom []))
  (doseq [race-day race-days]
    (swap! total running-f race-day)
    (swap! race-totals conj {:race_date (:race_date race-day) :total @total :finishes (:finishes race-day)}))
  @race-totals)

(defroutes routes
  "url routes for the web app to serve"
  (GET "/"
       []
       (page/index [{:title "Lay Bets" :value (running-total (race-day-lay-results) running-lay-total)}
                    {:title "Back Bets" :value (running-total (race-day-back-results) running-back-total)}]
                   [page/link-lay page/link-back]))
  (GET "/lay"
       []
       (page/index [{:title "Original Lay Bets" :value (running-total (race-day-lay-results) running-lay-total)}
                    {:title "New Lay Bets" :value (running-total (race-day-lay-results
                                                                            (finishing-positions (first-race-only))
                                                                            (core/magic-number-f 1 5 1.5 0.25)
                                                                            core/third-odds-difference)
                                                                 running-lay-total)}
                    {:title "Everything Under -5" :value (running-total (race-day-lay-results
                                                                         (finishing-positions (below-magic-number-of -5))
                                                                         (core/magic-number-f 1 5 1.5 0.25)
                                                                         core/third-odds-difference)
                                                                        running-lay-total)}
                    ]
                   [page/link-back page/link-index]))
  (GET "/back"
       []
       (page/index [{:title "Original Back Bets" :value (running-total (race-day-back-results) running-back-total)}
                    {:title "New Back Bets" :value (running-total (race-day-back-results
                                                                            (finishing-positions (first-race-only))
                                                                            (core/magic-number-f 1 5 1.5 0.25))
                                                                 running-back-total)}
                    ;; {:title "Everything Over 5" :value (running-total (race-day-back-results
                    ;;                                                      (finishing-positions (below-magic-number-of -5))
                    ;;                                                      core/new-magic-number
                    ;;                                                      core/third-odds-difference)
                    ;;                                                     running-back-total)}
                    ]
                   [page/link-lay page/link-index]))
  (route/files "/" {:root "public"}))

(defn start
  "start web app server up, defaults to 8080, 'wrap-reload' only works in development mode, need to comment out the ring reload lib as well"
  ([] (start 8080))
  ([port]
      (ring/run-jetty (wrap-reload #'routes '(gg-clj.core gg-clj.app gg-clj.mail gg-clj.web gg-clj.db gg-clj.page)) {:port port :join? false})
      ;;(ring/run-jetty #'routes {:port port :join? false})
      ))

(def race-date-format (DateTimeFormat/forPattern "yyyy-MM-dd"))

(defn get-races-for-today
  "load today's races out of the db, create them by scraping the racing post website if they don't already exist."
  []
  (info (str "checking if race exists:" (db/race-day-today-exists)))
  (if-not (db/race-day-today-exists)
    (db/create-race-day (web/multi-race-pages)))
  (:races (db/get-race-day)))

(defn convert-date-to-string
  "convert a date into format used by date parameters in racing post URLs, assumes date passed in is probably a java.sql.Date"
  [date]
  (.print race-date-format (LocalDate/fromDateFields date)))

(defn -main
  "requires one argument to do anything.  If 'bets' then it sends out emails for today's recommended lay and back bets (creating the records in the db if they don't exists already).  This is currently scheduled to run every day at 9.30am.

If 'results' then the database is updated with the finishing position of horses for any horses that don't currently have a finishing position except for today.  This is currently scheduled to run every day at 1am."
  [& args]
  (info (str "started with args " args))
  (if (=  (first args) "bets")
    (let [races (get-races-for-today)
          emails (db/get-emails)]
      (mail/send-lay-races races emails)
      (mail/send-back-races races emails)))
  (if (= (first args) "results")
    (doseq [date (db/race-days-with-no-results)]
      (def positions (web/get-horse-positions (convert-date-to-string (:race_date date))))
      (db/update-positions positions (:race_date date))))
  (if (= (first args) "app")
    (let [port (Integer. (or (System/getenv "PORT") 8080))]
      (start port)))
  (info "exiting..."))