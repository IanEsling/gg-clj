(ns gg-clj.db
  	(:use korma.db)
  	(:use korma.core)
  	(:use clojure.tools.logging)
    (:use clj-logging-config.log4j)
  	(:import [org.joda.time DateTime]))

(set-logger! :level :info 
    	     :additivity false
        	 :pattern "%p - %m%n") 

(defdb db (postgres 
			(if-let [url (java.net.URI. (System/getenv "DATABASE_URL"))]
            	{:user (get (clojure.string/split (.getUserInfo url) #":") 0) 
         		:password (get (clojure.string/split (.getUserInfo url) #":") 1)
                 :db (subs (System/getenv "DATABASE_URL") (+ 1 (.lastIndexOf (System/getenv "DATABASE_URL") "/")))
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
  (info (str "creating race day with connection: " (:user db) (:password db) (:db db)))
  (-> (:id (insert race-day (values {:race_date (java.sql.Date. (.getMillis (DateTime.)))})))
      (create-races races)))