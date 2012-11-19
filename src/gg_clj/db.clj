(ns gg-clj.db
  	(:use korma.db)
  	(:use korma.core)
  	(:use [clj-time.core :excludes [extend]])
	(:use clj-time.coerce))

(defdb db (postgres {:db "gg"}))

(defentity race-day (table :race_day))
(defentity race (table :race))
(defentity horse (table :horse))

(defn create-horse [{:keys [tips odds name race-id]}]
  (insert horse (values {:tips tips
                         :odds odds
                         :name name
                         :race_id race-id
                         })))

(defn create-race [{:keys [runners venue time race-day-id]}]
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