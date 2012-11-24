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

(defn save-races []
  	(info "Starting up saving races...")
	(create-race-day (race-pages))
  	(info "Finished saving races."))

(defn -main [& args]
  (info (str "using database url: " (System/getenv "DATABASE_URL")))
			(let [url (java.net.URI. (System/getenv "DATABASE_URL"))]
            	(info (str "user: " (get (clojure.string/split (.getUserInfo url) #":") 0))) 
         		(info (str "password: " (get (clojure.string/split (.getUserInfo url) #":") 1)))
                (info (str "db: " (subs (System/getenv "DATABASE_URL") (+ 1 (.lastIndexOf (System/getenv "DATABASE_URL") "/")))))
				)
            (let [race-pages (race-pages)]
			    (create-race-day race-pages)
    			(send-races race-pages)))
;;  (-> (race-pages) (create-race-day) (send-races)))
;;	(send-races (race-pages)))
  ;;(save-races))

