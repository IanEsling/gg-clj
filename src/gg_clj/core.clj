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

(defn -main [& args]
            (let [race-pages (multi-race-pages)]
			    (create-race-day race-pages)
    			(send-races race-pages)))