(ns gg-clj.core
	(:gen-class)
	(:use gg-clj.web)
  	(:use gg-clj.db)
  	(:use gg-clj.mail)
  	(:use clojure.tools.logging)
  	(:use clj-logging-config.log4j))

(set-logger! :level :info
    	     :additivity false
        	 :pattern "%p - %m%n"
             )

(defn get-races-for-today []
  (info (str "checking if race exists:" (race-day-today-exists)))
  (if-not (race-day-today-exists)
    (create-race-day (multi-race-pages)))
  (:races (get-race-day)))

(defn -main [& args]
  (info (str "started with args " args))
  (let [races (get-races-for-today)
        emails (get-emails)]
    (send-lay-races (races) emails)
    (send-back-races (races) emails)))