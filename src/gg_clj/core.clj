(ns gg-clj.core
	(:gen-class)
	(:use gg-clj.web :as web)
  	(:use gg-clj.db :as db)
  	(:use gg-clj.mail :as mail)
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
  (info (str "checking if race exists:" (db/race-day-today-exists)))
  (if-not (db/race-day-today-exists)
    (db/create-race-day (web/multi-race-pages)))
  (:races (db/get-race-day)))

(defn convert-date-to-string [date]
  (.print race-date-format (LocalDate/fromDateFields date)))

(defn -main [& args]
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
  (info "exiting..."))