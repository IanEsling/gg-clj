(ns gg-clj.mail-test
  (:use gg-clj.mail)
  (:use midje.sweet))

(def race {:venue "V" :time "12.34" :runners 4
                    :horses '({:name "h1" :odds "2/1" :tips 2}
                              {:name "h2" :odds "3/1" :tips 1})})

(def race2 {:venue "V" :time "13.34" :runners 11
                    :horses '({:name "h3" :odds "3/1" :tips 4}
                              {:name "h4" :odds "Evs" :tips 1})})

(def race3 {:venue "V" :time "14.34" :runners 9
                    :horses '({:name "h5" :odds "3/1" :tips 4}
                              {:name "h6" :odds "9/10" :tips 1})})


(fact "only bettable races should be emailed"
      (count (emailable-races [race race2 race3])) => 2
      (map #(:time %) (emailable-races [race race2 race3])) => (contains ["12.34" "13.34"] :in-any-order)
      )


(fact "horses should have magic numbers calculated"
      	(every? #(:magic-number %) (:horses (emailable-race race))) => true
		(:magic-number (first (filter #(= (:name %) "h1") (:horses (emailable-race race))))) => -1
      	(:magic-number (first (filter #(= (:name %) "h4") (:horses (emailable-race race2))))) => -8
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