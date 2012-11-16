(ns gg-clj.web-test
	(:use gg-clj.web)
  	(:use gg-clj.web-pages)
  	(:use midje.sweet))


(fact "race day urls parsed from website"
	(count (get-race-urls urls-page)) => 27)

(def race (get-race race-page))

(fact "race parsed from race page"
      (:venue race) => "Venue 1"
      (:time race) => "12:45"
      (:runners race) => "17")

(fact "horses parsed from race page"
      (count (:horses race)) => 8
		(:horses race) => (contains {:name "No Deal" :odds "7/4" :tips 3} :in-any-order)
		(:horses race) => (contains {:name "Cloud Creeper" :odds "9/4" :tips 5} :in-any-order)
		(:horses race) => (contains {:name "Mandarin Sunset" :odds "6/1" :tips 1} :in-any-order)
		(:horses race) => (contains {:name "Phoenix Returns" :odds "6/1" :tips 0} :in-any-order)
		(:horses race) => (contains {:name "Brae On" :odds "12/1" :tips 0} :in-any-order)
		(:horses race) => (contains {:name "Two Oscars" :odds "16/1" :tips 2} :in-any-order)
		(:horses race) => (contains {:name "Bold Slasher" :odds "20/1" :tips 1} :in-any-order)
		(:horses race) => (contains {:name "Big Sound" :odds "25/1" :tips 4} :in-any-order))