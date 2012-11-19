(ns gg-clj.db
  	(:use korma.db)
  	(:use korma.core)
	(:use [clj-time.core :exclude [extend]])
  	(:use clj-time.coerce))

(defdb db (postgres {:db "gg"}))

(defentity race-day (table :race_day))
(defentity race (table :race))
(defentity horse (table :horse))

(defn all-races []
(select race
        (fields :venue :time)))

(defn all-race-days []
  (select race-day))

(defn create-race-day []
  (insert race-day (values {:race_date (to-sql-date (now))})))

(defn create-horses [race-id horses]
  (println race-id horses)
	(doseq [h horses]
      (insert horse (values {:tips (:tips h)
                             :odds (:odds h)
                             :name (:name h)
                             :race_id race-id
                             }))))

(defn create-races [race-day-id races]
	(doseq [r races]
		(-> (:id (insert race 
                 (values {:number_of_runners 
                          (:number_of_runners r)
                          :venue (:venue r)
                          :time (:time r)
                          :race_day_id race-day-id
                          })))
        (create-horses (:horses r)))))
