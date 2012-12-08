(ns gg-clj.core-test
  (:use [gg-clj.core :as core])
  (:use midje.sweet)
  )

(def race {:venue "V" :time "12.34" :number_of_runners 4
                    :horses '({:name "h1" :odds "2/1" :tips 2}
                              {:name "h2" :odds "3/1" :tips 1})})

(defn get-magic-number-for-horse [name]
  (comp :magic-number first (partial filter #(= (:name %) name)))
  )

(defn new-magic-number [horse race]
  (- (core/magic-number horse race) (reduce (fn [mn h] (if (= (:name h) (:name horse)) mn (+ mn (:tips h)))) 0 (:horses race)))  
  )

(fact "should have magic number calculated"
      ((get-magic-number-for-horse "h1") (:horses (core/calculate-lay-bet-race race new-magic-number))) => -2            
)