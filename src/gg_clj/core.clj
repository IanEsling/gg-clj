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

(defn get-races-for-today
  "load today's races out of the db, create them by scraping the racing post website if they don't already exist."
  []
  (info (str "checking if race exists:" (race-day-today-exists)))
  (if-not (race-day-today-exists)
    (create-race-day (multi-race-pages)))
  (:races (get-race-day)))

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
          emails (get-emails)]
      (send-lay-races races emails)
      (send-back-races races emails)))
  (if (= (first args) "results")
    (doseq [date (race-days-with-no-results)]
      (def positions (get-horse-positions (convert-date-to-string (:race_date date))))
      (update-positions positions (:race_date date))))
  (info "exiting..."))