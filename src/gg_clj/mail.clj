(ns gg-clj.mail
  (:use [clojure.string :exclude [reverse]]))

(defn numeric-odds [odds]
  (let [components (for [s (split (replace odds "Evs" "1/1") #"/")] (read-string s))]
        	(/ (first components) (second components))))

(defn add-bettable [race]
      (assoc race :bettable (< 0 (count
									(filter #(let [odds (numeric-odds %)]
										(and (>= 2 odds) (<= 1 odds)))
									(map #(:odds %) (:horses race)))))))

(defn sorted-odds [race]
  (sort (map #(numeric-odds %) (map #(:odds %) (:horses race)))))

(defn add-difference-in-odds [race]
  (let [odds (sorted-odds race)
        first (first odds)
        second (second odds)]

  	(assoc race :odds-diff (- second first))))

(defn remove-non-favourites [race]
	(assoc race :horses (filter 
                         #(= (first (sorted-odds race)) (numeric-odds (:odds %))) 
                                (:horses race))))

(defn magic-number [horse race]
    	(- 
         (+ (:odds-diff race)(:tips horse))
           (:runners race)))

(defn add-magic-number [race]
  (assoc race :horses
	(for [horse (:horses race)]
		(assoc horse :magic-number (magic-number horse race)))))

(defn emailable-race [race]
	(-> (add-bettable race) (add-difference-in-odds) (remove-non-favourites) (add-magic-number)))

(defn emailable-races [races]
  (filter #(:bettable %)
          (for [race races]
            (emailable-race race))))