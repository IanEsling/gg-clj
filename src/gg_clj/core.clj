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

(defn get-race-pages []
  (info (str "checking if race exists:" (race-day-today-exists)))
  (if-not (race-day-today-exists)
    (create-race-day (multi-race-pages)))
    (get-existing-race-days))

(defn -main [& args]
  (info (str "started with args " args))
            (let [race-pages (get-race-pages)]
              	;;(create-race-day race-pages)
              ;;(info "sending races: " (:races (first race-pages)))
              (send-lay-races (:races (first race-pages)) (get-emails))
              (send-back-races (:races (first race-pages)) (get-emails))))