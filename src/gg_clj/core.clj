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
             :out (org.apache.log4j.DailyRollingFileAppender.
                  (org.apache.log4j.EnhancedPatternLayout. "%d %r [%t] %p %c - %m%n")
                  "logs/gg.log"
                  "yyyy-MM-dd"))

(defn save-races []
  	(info "Starting up saving races...")
	(create-race-day (race-pages))
  	(info "Finished saving races."))

(defn -main [& args]
  (let [race-pages (race-pages)]
    (create-race-day race-pages)
    (send-races race-pages)))
;;  (-> (race-pages) (create-race-day) (send-races)))
;;	(send-races (race-pages)))
  ;;(save-races))

