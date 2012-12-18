(ns gg-clj.db
        (:use [ clojure.string :only [blank? lower-case]])
  	(:use korma.db)
  	(:use korma.core)
  	(:use clojure.tools.logging)
        (:use clj-logging-config.log4j)
  	(:import [org.joda.time DateTime]))

(set-logger! :level :info 
    	     :additivity false
        	 :pattern "%r %p - %m%n") 

;;setup database, assume if we don't have a 'DATABASE_URL' available
;;then we're not running on Heroku and look for a local one (called 'gg')
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

;;the email table holds a list of email addresses to send the lay and
;;back bets to
(defentity emails (table :email))

(defn get-emails []
  (map #(:address %) (select emails))) 

;;all the horses
(defentity horses (table :horse))

;;all the races
(defentity races (table :race) (has-many horses {:fk :race_id})
           (transform (fn [r] (assoc r :horses (:horse r)))))

;;top-level entity, the race day
(defentity race-day (table :race_day) (has-many races {:fk :race_day_id})
           (transform (fn [r] (assoc r :races (:race r)))))

(defn create-horse
  "create a horse for a given race"
  [{:keys [tips odds name race-id]}]
  (info (str "saving " name " at " odds))
  (insert horses (values {:tips tips
                         :odds odds
                         :name name
                         :race_id race-id
                         })))

(defn create-race
  "create a race for a given race day"
  [{:keys [runners venue time race-day-id]}]
  (info (str "saving " time " at " venue))
  (insert races (values {:number_of_runners (Integer/valueOf runners)
                        :venue venue
                        :time time
                        :race_day_id race-day-id
                        })))

(defn create-horses
  "associate a race id with a list of horses and insert into db"
  [race-id horses]
  (doseq [h (map #(assoc % :race-id race-id) horses)]
      (create-horse h)))

(defn create-races
  "associate a race day id with a list of races and insert into db"
  [race-day-id races]
	(doseq [r (map #(assoc % :race-day-id race-day-id) races)]
		(-> (:id (create-race r))
        (create-horses (:horses r)))))

(defn create-race-day
  "create a race day for today and associate all the races passed in with it."
  [races-to-create]
  (-> (:id (insert race-day (values {:race_date (java.sql.Date. (.getMillis (DateTime.)))})))
      (create-races races-to-create)))

(defn race-day-today-exists
  "return true if a race day exists for today."
  []
  (< 0 (count (select race-day (where
                                {:race_date (java.sql.Date. (.getMillis (DateTime.)))})))))

(defn get-latest-race-day
  "get the race day, race and horses for most recent one in database"
  []
  (last (select race-day (with races (with horses)))))

(defn get-race-day
  "get the race day, race and horses for today"
  ([] (get-race-day (java.sql.Date. (.getMillis (DateTime.)))))
  ([date]
     (first  (select race-day (where
                               {:race_date date})
                     (with races (with horses))))))

(defn race-days-with-results
  "get all the dates for which we have race days with results (i.e. horses with finishing position)"
  []
  (info "checking for race days with results...")
  (exec-raw ["select rd.race_date from race_day rd, race r where rd.id = r.race_day_id and not exists (select 1 from horse h where r.id = h.race_id and h.finish is null) group by rd.id order by 1;"] :results))

(defn race-days-with-no-results
  "get all the dates for which we have race days with no results (i.e. horses with no finishing position)"
  []
  (info "checking for race days with no results...")
  (exec-raw ["select rd.race_date from race_day rd, race r, horse h where rd.id = r.race_day_id and r.id = h.race_id and h.finish is null and rd.race_date != current_date group by rd.id order by 1;"] :results))

(defn update-positions
  "update horses in db with finishing positions"
  [positions date]
  (doseq [horse (flatten (map :horses (:races (first (select race-day (where {:race_date date}) (with races (with horses)))))))]
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
