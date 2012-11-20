(ns gg-clj.db
  	(:use korma.db)
  	(:use korma.core)
  	(:use clojure.tools.logging)
    (:use clj-logging-config.log4j)
  	(:use [clj-time.core :exclude [extend]])
	(:use clj-time.coerce))

(set-logger! :level :info 
    	     :additivity false
        	 :pattern "%p - %m%n"
             :out (org.apache.log4j.DailyRollingFileAppender.
                  (org.apache.log4j.EnhancedPatternLayout. "%d %r [%t] %p %c - %m%n")
                  "logs/gg.log"
                  "yyyy-MM-dd")) 

(defdb db (postgres 
			(if-let [url (System/getenv "DATABASE_URL")]
            	{:user (get (clojure.string/split (.getUserInfo url) #":") 0) 
         		:password (get (clojure.string/split (.getUserInfo url) #":") 1)
                 :db (subs url (+ 1 (.lastIndexOf url "/")))
				}

              {:db "gg"})))

(defentity race-day (table :race_day))
(defentity race (table :race))
(defentity horse (table :horse))

(defn create-horse [{:keys [tips odds name race-id]}]
  (info (str "saving " name " at " odds))
  (insert horse (values {:tips tips
                         :odds odds
                         :name name
                         :race_id race-id
                         })))

(defn create-race [{:keys [runners venue time race-day-id]}]
  (info (str "saving " time " at " venue))
  (insert race (values {:number_of_runners (Integer/valueOf runners)
                        :venue venue
                        :time time
                        :race_day_id race-day-id
                        })))

(defn create-horses [race-id horses]
  (doseq [h (map #(assoc % :race-id race-id) horses)]
      (create-horse h)))

(defn create-races [race-day-id races]
	(doseq [r (map #(assoc % :race-day-id race-day-id) races)]
		(-> (:id (create-race r))
        (create-horses (:horses r)))))

(defn create-race-day [races]
  (-> (:id (insert race-day (values {:race_date (to-sql-date (now))})))
      (create-races races)))