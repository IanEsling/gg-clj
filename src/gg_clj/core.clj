(ns gg-clj.core
	(:gen-class)
	(:use gg-clj.web)
  	(:use gg-clj.db)
  	(:use gg-clj.mail)
  	(:use clojure.tools.logging)
  	(:use clj-logging-config.log4j)
        (:import [org.joda.time.format DateTimeFormat])
        (:import [org.joda.time LocalDate]))

(set-logger! :level :info
    	     :additivity false
        	 :pattern "%p - %m%n"
                 )

(def race-date-format (DateTimeFormat/forPattern "yyyy-MM-dd"))

(defn get-races-for-today []
  (info (str "checking if race exists:" (race-day-today-exists)))
  (if-not (race-day-today-exists)
    (create-race-day (multi-race-pages)))
  (:races (get-race-day)))

(defn convert-date-to-string [date]
  (.print race-date-format (LocalDate/fromDateFields date)))

(defn -main [& args]
  (info (str "started with args " args))
  (if (=  (first args) "bets")
    (let [races (get-races-for-today)
          emails (get-emails)]
      (send-lay-races races emails)
      (send-back-races races emails)))
  (if (= (first args) "results")
    (doseq [date (race-days-with-no-results)]
      (def positions (get-horse-positions (convert-date-to-string (:race_date date))))
      (update-positions positions (:race_date date))))
  (info "exiting..."))