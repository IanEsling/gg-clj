(ns gg-clj.core
  	(:use clojure.tools.logging)
  	(:use clj-logging-config.log4j))

(set-logger! :level :info
    	     :additivity false
        	 :pattern "%p - %m%n"
                 )

(defn if-bettable
  "call f on race if bettable"
  [race f]
  (if (:bettable race)
    (f race)
    race))

(defn if-has-horses
  "call f on race if it has horses"
  [race f]
  (if (:has-horses race)
    (f race)
    race))

(defn numeric-odds
  "turn string odds description (e.g. '3/1') into a numeric we can work with, turns 'Evs' (evens) into '1/1'"
  [odds]
  (let [components (for [s (.split #"/" (.replace odds "Evs" "1/1"))] (read-string s))]
        	(/ (first components) (second components))))

(defn add-has-horses
  "adds a true/false 'has-horses' flag to a race (true if there's one or more horses)"
  [race]
  (assoc race :has-horses (< 0 (count (:horses race)))))

(defn add-bettable
  "addes a true/false bettable flag to a race (true if there's a horse with odds between 1/1 and 2/1)"
  [race]
  (info (str "working out if bettable: " race))
      (assoc race :bettable (< 0 (count
                                  (filter #(let [odds (numeric-odds %)]
                                             (and (>= 2 odds) (<= 1 odds)))
                                          (map #(:odds %) (:horses race)))))))

(defn sorted-odds
  "return a sorted list of odds for the horses in a race"
  [race]
  (sort (map #(numeric-odds %) (map #(:odds %) (:horses race)))))

(defn add-difference-in-odds
  "add to a race the difference in odds between the first and second favourites"
  [race]
  (let [odds (sorted-odds race)
    	first (first odds)
        second (second odds)]

  	(assoc race :odds-diff (- second first))))

(defn remove-non-favourites
  "remove any horses that don't have the favourite's odds (may have joint favourites in a race)"
  [race]
	(assoc race :horses (filter 
                         #(= (first (sorted-odds race)) (numeric-odds (:odds %))) 
                                (:horses race))))

(defn magic-number
  "calculate magic number for a horse in a race"
  [horse race]
  (info (str "calculating magic number..." horse race))
    	(- 
         (+ (:odds-diff race)(:tips horse))	
           (:number_of_runners race)))

(defn add-magic-number
  "calculate the magic number for each horse in a race"
  [race]
  (assoc race :horses
	(for [horse (:horses race)]
		(assoc horse :magic-number (magic-number horse race)))))

(defn get-lowest-magic-number
  "work out the lowest magic number for all the horses in a race"
  [race]
    (assoc race :lowest-magic-number 
      (reduce (fn [i j] (if (< i j) i j)) 100 
            (map :magic-number (:horses race)))))

(defn get-highest-magic-number
  "work out the highest magic number for all the horses in a race"
  [race]
    (assoc race :highest-magic-number 
      (reduce (fn [i j] (if (> i j) i j)) -100 
              (map :magic-number (:horses race)))))

(defn calculate-lay-bet-race
  "calculate all the bits needed for lay betting on a race"
  [race]
  (info (str "calculating lay race: " race))
	(-> (add-bettable race) 
        (if-bettable add-difference-in-odds) 
        (if-bettable remove-non-favourites) 
        (if-bettable add-magic-number) 
        (if-bettable get-lowest-magic-number)))

(defn calculate-back-bet-race
  "calculate all the bits needed for back betting on a race"
  [race]
  (info (str "calculating back race: " race))
	(-> (add-has-horses race)
        (if-has-horses add-difference-in-odds) 
        (if-has-horses remove-non-favourites) 
        (if-has-horses add-magic-number) 
        (if-has-horses get-highest-magic-number)))

(def lowest-magic-number-comparator (comparator (fn [i j] (< i j))))

(def highest-magic-number-comparator (comparator (fn [i j] (> i j))))

(defn calculate-lay-bet-races
  "get bettable calculated races in a sensible order"
  [races]    
    (sort-by :lowest-magic-number lowest-magic-number-comparator        
      (filter #(:bettable %)
              (for [race races]
                (calculate-lay-bet-race race)))))

(defn calculate-back-bet-races
  "get bettable calculated races in a sensible order"
  [races]    
  (sort-by :highest-magic-number highest-magic-number-comparator
           (filter #(:has-horses %)
                   (for [race races]
                     (calculate-back-bet-race race)))))