(ns gg-clj.core
  (:use clojure.tools.logging)
  (:use clj-logging-config.log4j))

(set-logger! :level :info
             :additivity false
             :pattern "%r %p - %m%n"
             :out (org.apache.log4j.FileAppender.
                   (org.apache.log4j.EnhancedPatternLayout. org.apache.log4j.EnhancedPatternLayout/TTCC_CONVERSION_PATTERN)
                   "logs/core.log"
                   true)
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
  ;;  (info (str "working out if bettable: " race))
  (assoc race :bettable (< 0 (count
                              (filter #(let [odds (numeric-odds %)]
                                         (and (>= 2 odds) (<= 1 odds)))
                                      (map #(:odds %) (:horses race)))))))

(defn sorted-odds
  "return a sorted list of odds for the horses in a race"
  [race]
  (sort (map #(numeric-odds %) (map #(:odds %) (:horses race)))))

(defn odds-difference-f [next-odds-pos]
  (fn [race]
    (let [odds (sorted-odds race)]
      (try (nth odds next-odds-pos)
           (catch Exception e
             (prn next-odds-pos odds )))
      
      (assoc race :odds-diff (- (nth odds (if (>= next-odds-pos (count odds)) (- (count odds) 1)  next-odds-pos)) (first odds))))))

;; (defn first-odds-difference [next-odds-pos race]
;;   ((partial odds-difference first) (partial nth race next-odds-pos) race))

;; (defn second-odds-difference [race]
;;   ((partial first-odds-difference 1 race)))

;; (defn third-odds-difference [race]
;;   ((partial first-odds-difference 2 race)))

(defn tips-on-other-horses [horse-name race]
  (reduce (fn [mn h] (if (= (:name h) horse-name) mn (+ mn (:tips h)))) 0 (:horses race)))

(defn add-other-tips [race]
  (assoc race :horses
         (for [horse (:horses race)]
           (assoc horse :other-tips (tips-on-other-horses (:name horse) race)))))

(defn remove-non-favourites
  "remove any horses that don't have the favourite's odds (may have joint favourites in a race)"
  [race]
  (assoc race :horses (filter
                       #(= (first (sorted-odds race)) (numeric-odds (:odds %)))
                       (:horses race))))

(defn magic-number
  "calculate magic number for a horse in a race"
  [horse race]
  ;;  (info (str "calculating magic number..." horse race))
  (-
   (+ (:odds-diff race)(:tips horse))
   (:number_of_runners race)))

(defn magic-number-f
  ([map] (magic-number-f (:odds-diff map) (:tips map) (:runners map) (:other-tips map)))
  ([odds-diff tips number-of-runners other-tips]
     (fn [horse race]
        (-
         (-
          (+ (* odds-diff (:odds-diff race)) (* tips (:tips horse)))
          (* number-of-runners (:number_of_runners race)))
         (* other-tips (reduce (fn [mn h] (if (= (:name h) (:name horse)) mn (+ mn (:tips h)))) 0 (:horses race)))))))

(defn add-magic-number
  "calculate the magic number for each horse in a race"
  [magic-num-f race]
  (assoc race :horses
         (for [horse (:horses race)]
           (assoc horse :magic-number (magic-num-f horse race)))))

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
  ([race] (calculate-lay-bet-race race magic-number))
  ([race magic-num-f] (calculate-lay-bet-race race magic-num-f (odds-difference-f 1)))
  ([race magic-num-f odds-diff-f]
     (-> (add-bettable race)
         (if-bettable odds-diff-f)
         (if-bettable add-other-tips)         
         (if-bettable (partial add-magic-number magic-num-f))
         (if-bettable remove-non-favourites)
         (if-bettable get-lowest-magic-number))))

(defn calculate-back-bet-race
  "calculate all the bits needed for back betting on a race"
  ([race] (calculate-back-bet-race race magic-number (odds-difference-f 1)))
  ([race magic-num-f odds-diff-f]
     (-> (add-has-horses race)
         (if-has-horses odds-diff-f)
         (if-has-horses add-other-tips)
         (if-has-horses remove-non-favourites)
         (if-has-horses (partial add-magic-number magic-num-f))
         (if-has-horses get-highest-magic-number))))

(def lowest-magic-number-comparator (comparator (fn [i j] (< i j))))

(def highest-magic-number-comparator (comparator (fn [i j] (> i j))))

(defn calculate-lay-bet-races
  "get bettable calculated races in a sensible order"
  ([races] (calculate-lay-bet-races magic-number races))
  ([magic-number-f races] (calculate-lay-bet-races magic-number (odds-difference-f 1) races))
  ([magic-number-f odds-diff-f races]
     (sort-by :lowest-magic-number lowest-magic-number-comparator
              (filter #(:bettable %)
                      (for [race races]
                        (calculate-lay-bet-race race magic-number-f odds-diff-f))))))

(defn calculate-back-bet-races
  "get bettable calculated races in a sensible order"
  ([races] (calculate-back-bet-races magic-number (odds-difference-f 1) races))
  ([magic-number-f odds-diff-f races]
     (sort-by :highest-magic-number highest-magic-number-comparator
              (filter #(:has-horses %)
                      (for [race races]
                        (calculate-back-bet-race race magic-number-f odds-diff-f))))))