(ns gg-clj.web-test
	(:use gg-clj.web)
  	(:use gg-clj.web-pages)
  	(:use midje.sweet))


(fact "race day urls parsed from website"
	(count (get-race-urls urls-page)) => 27)

(fact "race venue parsed from race page"
      (def race (get-race race-page))
      (:venue race) => "Venue 1"
      (:time race) => "12:45")