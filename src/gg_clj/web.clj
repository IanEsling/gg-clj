(ns gg-clj.web
  	(:use clojure.set)
  	(:use [clojure.string :only [trim]])
  	(:import 	[org.jsoup Jsoup]
   				[org.jsoup.nodes Document]))

(def racing-post-base-url "http://betting.racingpost.com")

(def race-index-url (str racing-post-base-url "/horses/cards"))

(defn- connection []
  (Jsoup/connect race-index-url))

(defn- page []
  (.get (connection)))

(defn- get-anchor-href [coll a]
  (conj coll (.attr a "href")))

(defn- get-race-urls-from-selector [page-f css-selector]
	(reduce get-anchor-href #{}
	(.select (page-f) css-selector)))

(defn get-race-urls [page-f]
	(apply union (for [css-selector ["div.leftColumn table strong a" 
                                  "div.rightColumn table strong a"]]
  					(get-race-urls-from-selector page-f css-selector))))

(defn- get-runners [race-page]
	(loop [info (.select (race-page) "p.raceShortInfo span")]
  		(def span (first info))
  		(if (= "Runners: " (.text (first (.textNodes span))))
    		(.text (.select span "strong"))
    		(recur (rest info)))))

(defn get-favourites [favourites]
(reduce (fn faves [coll b]
          (conj coll
                {:name
				(.text (first (.getElementsByTag b "a")))
				:odds
				(trim (first (.textNodes b)))}))
                '()
				favourites))

(defn get-odds [betting-forecast]
  (map (fn [o] (trim (subs (.text o) 2)))
	(filter (fn [node] (< 2 (.length (.text node))))
	(.textNodes
 	(first (.getElementsByTag betting-forecast "p"))))))

(defn get-horse-names [betting-forecast]
	(map (fn [a] (.text a))
	(.select betting-forecast "p > a")))

(defn get-horses [odds names coll]
  (if (not (seq odds))
    coll
	(recur (rest odds) (rest names) 
           (conj coll {:name (first names) :odds (first odds)}))))

(defn tips [race-page]
	(reduce (fn [coll e]
          (assoc coll (.text (.select e "td.h b"))
                      (.text (.select e "div.tips"))))
        {}
	(.select (race-page) "table#sc_sortBlock > tbody")))

(defn add-tips [horses race-page]
	(map (fn [h] (assoc h :tips (Integer/valueOf (get (tips race-page) (.toUpperCase (:name h))))))
		horses))

(defn get-race [race-page]
  (let [race (race-page)
        betting-forecast (first (.select (race-page) "div.info"))
        venue (.text (first (.select race "h1 > span")))
        time (.text (first (.select race "h1 > strong")))]
    {:venue venue
	:time time
    :runners (get-runners race-page)
     :horses (add-tips (reduce (fn [coll f] (conj coll f)) (get-horses (get-odds betting-forecast) (get-horse-names betting-forecast) '())
                   (get-favourites (.getElementsByTag betting-forecast "b"))) race-page)}))

(defn get-all-race-urls []
	(get-race-urls page))

(defn race-pages []
(for [url (get-all-race-urls)]
  (get-race (fn [] 
			  (.get 
				(.timeout
               (Jsoup/connect (str racing-post-base-url url))
                 60000)
              )))))