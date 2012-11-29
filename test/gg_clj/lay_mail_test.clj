(ns gg-clj.lay-mail-test
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
	(:bettable (emailable-race (assoc race :horses '()))) => false)

(fact "only bettable races should be emailed"
      (count (emailable-races [race race2 race3])) => 2
      (map #(:time %) (emailable-races [race race2 race3])) => (contains ["12.34" "13.34"] :in-any-order)
      (:time (first (emailable-races [race race2 race3]))) => "13.34"
      )

(fact "only favourite horses should be in the race"
      (count (:horses (emailable-race race))) => 1
      (count (:horses (emailable-race race4))) => 2
      )

(fact "horses should have magic numbers calculated"
      	(every? #(:magic-number %) (:horses (emailable-race race))) => true
		(:magic-number (first (filter #(= (:name %) "h1") (:horses (emailable-race race))))) => -1
      	(:magic-number (first (filter #(= (:name %) "h4") (:horses (emailable-race race2))))) => -8
        (:magic-number (first (filter #(= (:name %) "h8") (:horses (emailable-race race4))))) => -5
        (:magic-number (first (filter #(= (:name %) "h9") (:horses (emailable-race race4))))) => -8
      )

(fact "should calculate if race is bettable"
	(emailable-race race) => (contains {:bettable true})
	(emailable-race (assoc race :horses (for [horse (:horses race)] 
											(if (= (:name horse) "h1")
                                          		(assoc horse :odds "3/1")
                                              	horse)))) 
      => (contains {:bettable false})
	(emailable-race (assoc race :horses (for [horse (:horses race)] 
											(if (= (:name horse) "h1")
                                          		(assoc horse :odds "Evs")
                                              horse))))
      => (contains {:bettable true})
	(emailable-race (assoc race :horses (for [horse (:horses race)] 
											(if (= (:name horse) "h1")
                                          		(assoc horse :odds "99/100")
                                              horse))))
      => (contains {:bettable false}))