(ns gg-clj.app
  (:gen-class)
  (:use [gg-clj.db :as db])
  (:use [gg-clj.mail :as mail])
  (:use [gg-clj.web :as web])
  (:use [gg-clj.core :as core])
  (:use clojure.tools.logging)
  (:use clj-logging-config.log4j)
  (:use hiccup.core)
  (:use [compojure.core :only [defroutes GET]])
  (:use ring.middleware.reload)
  (:import [org.joda.time.format DateTimeFormat])
  (:import [org.joda.time LocalDate])
  (:require [ring.adapter.jetty :as ring])
  (:require [compojure.route :as route]))

(defn finish-positions-for-races [f]
  (fn [races]
    (for [race (f races)]
       (:finish (first (:horses race)))
      )))

(defn first-race-only []
  (comp vector first))

(defn finishing-positions [& fs]
    (finish-positions-for-races (apply comp fs)))

(defn below-magic-number-of [magic-number]
  (partial filter #(< (:lowest-magic-number %) magic-number)))

(defn odds-difference-less-than [odds-diff]
  (partial filter #(> odds-diff (:odds-diff %))))

(defn race-day-results
  ([races-f finish-f] (race-day-results races-f finish-f core/magic-number))
  ([races-f finish-f magic-number-f]
     (for [race-day (db/race-days-with-results)]
       {:race_date (.getTime (:race_date race-day))
        :finish (finish-f (races-f (:races (db/get-race-day (:race_date race-day))) magic-number-f))})))

(defn race-day-lay-results
  ([] (prn "race-day-lay-results with no args...") (race-day-lay-results (finishing-positions (first-race-only))))
  ([finish-f] (prn "race-day-lay-results with " finish-f) (race-day-lay-results finish-f core/magic-number))
  ([finish-f magic-number-f]
     (prn "race-day-lay-results with " finish-f magic-number-f)
     (race-day-results core/calculate-lay-bet-races finish-f magic-number-f)))

(defn race-day-back-results
  ([] (race-day-back-results (first-race-only)))
  ([finish-f]
     (race-day-results core/calculate-back-bet-races finish-f)))

(defn first-race-date-in-millis [race-day-results]
  (reduce (fn [t n]
            (prn t n)
            (if (< t n) t n)) (.getTime (java.util.Date.))
          (map :race_date race-day-results)))

(defn running-lay-total [x race-day]
  (prn (:finish race-day))
  (with-precision 5 (+ x (reduce (fn [tot finish]
                                   (+ tot (if (nil? finish) 0  (if (not= 1M (BigDecimal. finish)) 0.95M -2.0M))))
                                 0M
                                 (:finish race-day)))))

(defn running-back-total [x race-day]
   (with-precision 5 (+ x (reduce (fn [tot finish]
                                    (+ tot (if (not= 1M (BigDecimal. finish)) -1.0M 1.5M)))
                                 0M
                                 (:finish race-day)))))

(defn running-total [race-days running-f]
  (def total (atom 0M))
  (def race-totals (atom []))
  (doseq [race-day race-days]
    (swap! total running-f race-day)
    (swap! race-totals conj {:race_date (:race_date race-day) :total @total}))
  @race-totals)

(defn subs-miss-end [s]
  (subs s 0 (- (count s) 1)))

(defn chart-data [race-day-results]
  (def data (apply str (apply vector (map #(str % ",")  (map :total race-day-results)))))
  (prn data)
  (subs-miss-end data))

(defn chart-series [running-totals]
  (subs-miss-end (apply str
                        (for [running-total running-totals]
                          (str "{
                name: '"
                               (:title running-total)
                               "',
                pointInterval: 24 * 3600 * 1000,
                pointStart: "
                               (first-race-date-in-millis (:value running-total))
                               ",
                data: ["
                               (chart-data (:value running-total))
                               "]},"
                               )))))
             
(defn index-html
  "HTML for betting page"
  [running-totals]
    (html [:html 
           (html [:head [:link {:href "/css/gg.css" :media "screen" :rel "stylesheet" :type "text/css"}]
                  [:script {:type "text/javascript" :src "http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"}]
                  [:script {:type "text/javascript" :src "/js/highcharts.js"}]
                  [:script {:type "text/javascript"}
                   (str "$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                marginRight: 130,
                marginBottom: 25,
                type: 'spline'
            },
            title: {
                text: 'Betting Points',
                x: -20 //center
            },
            subtitle: {
                text: '',
                x: -20
            },
            xAxis: {
                type: 'datetime'
                },
            yAxis: {
                title: {
                    text: 'Number of Points'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            series: ["
                        (chart-series running-totals)
         "]});
    });
    
});")]])
           (html [:body
                  (html [:div {:id "container"}])])]))

(defroutes routes
  (GET "/"
       []
       (index-html [{:title "Original Lay Bets" :value (running-total (race-day-lay-results) running-lay-total)}
                    {:title "New Magic Number Lay Bets" :value (running-total (race-day-lay-results
                                                                               (finishing-positions (first-race-only))
                                                                               core/new-magic-number)
                                                                              running-lay-total)}
                    {:title "All Below Threshold" :value (running-total (race-day-lay-results
                                                                         (finishing-positions
                                                                          ;;(first-race-only)
                                                                          (below-magic-number-of -3)
                                                                          (odds-difference-less-than 2))
                                                                         core/new-magic-number)
                                                                        running-lay-total)}]))
  (route/files "/" {:root "public"}))

(defn start
  ([] (start 8080))
  ( [port]
      (ring/run-jetty (wrap-reload #'routes '(gg-clj.core gg-clj.app gg-clj.mail gg-clj.web gg-clj.db)) {:port port :join? false})
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