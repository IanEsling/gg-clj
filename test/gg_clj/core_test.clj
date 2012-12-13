(ns gg-clj.core-test
  (:use [gg-clj.core :as core])
  (:use midje.sweet)
  )

(def race {:venue "V" :time "12.34" :number_of_runners 4
                    :horses '({:name "h1" :odds "2/1" :tips 2}
                              {:name "h2" :odds "3/1" :tips 1})})

(def race2 {:venue "V2" :time "12:45" :number_of_runners 4
            :horses '({:name "h21" :odds "2/1"}
                      {:name "h22" :odds "3/1"}
                      { :name "h23" :odds "4/1"}
                      { :name "h24" :odds "5/1"})})

(defn get-magic-number-for-horse [name]
  (comp :magic-number first (partial filter #(= (:name %) name)))
  )

(defn test-magic-number [horse race]
  (- (core/magic-number horse race) (reduce (fn [mn h] (if (= (:name h) (:name horse)) mn (+ mn (:tips h)))) 0 (:horses race)))  
  )

(fact "should have magic number calculated"
      ((get-magic-number-for-horse "h1") (:horses (core/calculate-lay-bet-race race test-magic-number))) => -2            
      )

(fact "should have odds difference calculated"
      (:odds-diff (third-odds-difference race2)) => 2
      (:odds-diff (first-odds-difference second race)) => 1
      )