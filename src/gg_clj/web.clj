(ns gg-clj.web
  (:use clojure.set))

(defn- get-anchor-href [coll a]
  (conj coll (.attr a "href")))

(defn- get-race-urls-from-selector [page-f css-selector]
	(reduce get-anchor-href #{}
	(.select (page-f) css-selector)))

(defn get-race-urls [page-f]
	(apply union (for [css-selector ["div.leftColumn table strong a" 
                                  "div.rightColumn table strong a"]]
  					(get-race-urls-from-selector page-f css-selector))))

(defn get-runners [race-page]

(loop [info (.select (race-page) "p.raceShortInfo span")]
;;  (print  (first(.textNodes info)))
  (def span (first info))
  (print span)
  (print (.text (first (.textNodes span))))
  (if (= "Runners: " (.text (first (.textNodes span))))
    (.text (.select span "strong"))
    (recur (rest info)))))

(defn get-race [race-page]
  (let [race (race-page)]
	{:venue (.text
		(first 
		(.select race
         "h1 > span")))
	:time (.text
           (first
           (.select race
           	"h1 > strong")))
     :runners (get-runners race-page)}))