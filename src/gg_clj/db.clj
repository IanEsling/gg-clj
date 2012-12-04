(ns gg-clj.db
        (:use [ clojure.string :only [blank? lower-case]])
  	(:use korma.db)
  	(:use korma.core)
  	(:use clojure.tools.logging)
        (:use clj-logging-config.log4j)
  	(:import [org.joda.time DateTime]))

(set-logger! :level :info 
    	     :additivity false
        	 :pattern "%p - %m%n") 

(defdb db (postgres 
           (if-let [url (System/getenv "DATABASE_URL")]
             (let [uri (java.net.URI. url)]
            	{:user (get (clojure.string/split (.getUserInfo uri) #":") 0) 
         		:password (get (clojure.string/split (.getUserInfo uri) #":") 1)
                 :db (subs url (+ 1 (.lastIndexOf url "/")))
                 :host (.getHost uri)
                 :port (.getPort uri)
				})
              {:db "gg"})))

(defentity emails (table :email))

(defn get-emails []
  (map #(:address %) (select emails))) 

(defentity horses (table :horse))

(defentity races (table :race) (has-many horses {:fk :race_id})
           (transform (fn [r] (assoc r :horses (:horse r)))))

(defentity race-day (table :race_day) (has-many races {:fk :race_day_id})
           (transform (fn [r] (assoc r :races (:race r)))))

(defn create-horse [{:keys [tips odds name race-id]}]
  (info (str "saving " name " at " odds))
  (insert horses (values {:tips tips
                         :odds odds
                         :name name
                         :race_id race-id
                         })))

(defn create-race [{:keys [runners venue time race-day-id]}]
  (info (str "saving " time " at " venue))
  (insert races (values {:number_of_runners (Integer/valueOf runners)
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

(defn create-race-day [races-to-create]
  (-> (:id (insert race-day (values {:race_date (java.sql.Date. (.getMillis (DateTime.)))})))
      (create-races races-to-create)))

(defn race-day-today-exists []
  (< 0 (count (select race-day (where
                                {:race_date (java.sql.Date. (.getMillis (DateTime.)))})))))

(defn get-race-day []
  (first  (select race-day (where
                            {:race_date (java.sql.Date. (.getMillis (DateTime.)))})
                  (with races (with horses)))))

(defn race-days-with-no-results []
  (info "checking for race days with no results...")
  (exec-raw ["select rd.race_date from race_day rd, race r, horse h where rd.id = r.race_day_id and r.id = h.race_id and h.finish is null and rd.race_date != current_date group by rd.id order by 1;"] :results))

(defn update-positions [positions date]
  (doseq [horse (flatten (map :horses (:races (first (select race-day (where {:race_date date}) (with races (with horses)))))))]
    (prn horse)
    (update horses
            (set-fields {:finish (try  (Integer/valueOf
                                        (reduce (fn [pos h]
                                                  (let [{name :name position :position} h]
                                                    (if (= (lower-case (:name horse)) (lower-case name))
                                                      (if (blank? position)
                                                        999
                                                        position)
                                                      pos)))
                                                999 positions))
                                       (catch Exception e 999))})
            (where {:id (:id horse)}))))
