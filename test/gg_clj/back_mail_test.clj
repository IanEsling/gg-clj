(ns gg-clj.back-mail-test
  (:use gg-clj.mail)
  (:use midje.sweet))

(def race {:venue "V" :time "12.34" :number_of_runners 4
                    :horses '({:name "h1" :odds "2/1" :tips 2}
                              {:name "h2" :odds "3/1" :tips 1})})

(def race2 {:venue "V" :time "13.34" :number_of_runners 11
                    :horses '({:name "h3" :odds "3/1" :tips 4}
                              {:name "h4" :odds "Evs" :tips 1})})

(def race3 {:venue "V" :time "14.34" :number_of_runners 9
                    :horses '({:name "h5" :odds "3/1" :tips 4}
                              {:name "h6" :odds "9/10" :tips 1})})

(def race4 {:venue "V" :time "15.34" :number_of_runners 9
                    :horses '({:name "h8" :odds "Evs" :tips 4}
                              {:name "h9" :odds "Evs" :tips 1}
                              {:name "h7" :odds "21/10" :tips 1})})

(fact "shouldn't blow up if no horses in race"
	(:has-horses (emailable-back-bet-race (assoc race :horses '()))) => false)

(fact "only favourite horses should be in the race"
      (count (:horses (emailable-back-bet-race race))) => 1
      (count (:horses (emailable-back-bet-race race4))) => 2
      )

(fact "horses should have magic numbers calculated"
      	(every? #(:magic-number %) (:horses (emailable-back-bet-race race))) => true
		(:magic-number (first (filter #(= (:name %) "h1") (:horses (emailable-back-bet-race race))))) => -1
      	(:magic-number (first (filter #(= (:name %) "h4") (:horses (emailable-back-bet-race race2))))) => -8
        (:magic-number (first (filter #(= (:name %) "h8") (:horses (emailable-back-bet-race race4))))) => -5
        (:magic-number (first (filter #(= (:name %) "h9") (:horses (emailable-back-bet-race race4))))) => -8
      )