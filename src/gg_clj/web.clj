(ns gg-clj.web
  	(:use clojure.set)
  	(:use [clojure.string :only [trim]])
  	(:use clojure.tools.logging)
  	(:use clj-logging-config.log4j)
  	(:import 	[org.jsoup Jsoup]
   				[org.jsoup.nodes Document])
	(:import 	[java.util.concurrent Executors]))

(set-logger! :level :info 
    	     :additivity false
             :pattern "%p - %m%n")

(defn results-url
  "get the URL for the results of all the races for a given date (assumes a string in format yyyy-MM-dd)"
  [date] (str " http://www.racingpost.com/horses2/results/home.sd?r_date=" 
 date "&resultsTabs=runner_index"))

;;base URL for adding other bits to
(def racing-post-base-url "http://betting.racingpost.com")

;;top level URL for getting races
(def race-index-url (str racing-post-base-url "/horses/cards"))

(defn- connection
  "connect HTML parser"
  []
  (Jsoup/connect race-index-url))

(defn- page
  "get top level URL in parsable Document"
  []
  (.get (.timeout (connection) 60000)))

(defn- get-anchor-href
  "add an anchor element's href to a collection"
  [coll a]
  (conj coll (.attr a "href")))

(defn- get-race-urls-from-selector
  "pull link URLs from a given page and css selection"
  [page-f css-selector]
	(reduce get-anchor-href #{}
	(.select (page-f) css-selector)))

(defn get-race-urls
  "get all the URLs for all the difference races from links for the given page"
  [page-f]
	(apply union (for [css-selector ["div.leftColumn table strong a" 
                                  "div.rightColumn table strong a"]]
  					(get-race-urls-from-selector page-f css-selector))))

(defn- get-runners
  "loop over the part of a race page with the number of runners till we find it."
  [race-page]
       	(loop [info (.select race-page "p.raceShortInfo span")]
  		(def span (first info))
  		(if (= "Runners: " (.text (first (.textNodes span))))
    		(.text (.select span "strong"))
    		(recur (rest info)))))

(defn get-favourites
  "pull the favourites out from a race page into a list"
  [favourites]	
	(reduce (fn faves [coll b]
                  (conj coll
                        {:name
                         (.text (first (.getElementsByTag b "a")))
                         :odds
                         (trim (first (.textNodes b)))}))
                '()
                favourites))

(defn get-odds
  "pull the odds out of a race page's betting forecast"
  [betting-forecast]
  (map (fn [o] (trim (subs (.text o) 2)))
	(filter (fn [node] (< 2 (.length (.text node))))
	(.textNodes
 	(first (.getElementsByTag betting-forecast "p"))))))

(defn get-horse-names
  "pull the horse names out of a race page's betting forecast"
  [betting-forecast]
  	(map (fn [a] (.text a))
	(.select betting-forecast "p > a")))

(defn get-horses
  "loop over the odds and names collections putting them together, assumes they're both in the right order(!)"
  [odds names coll]
  (if (not (seq odds))
    coll
	(recur (rest odds) (rest names) 
           (conj coll {:name (first names) :odds (first odds)}))))

(defn tips
  "return a map of horse names with the number of tips they've got from the race page"
  [race-page]
  	(reduce (fn [coll e]
          (assoc coll (.text (.select e "td.h b"))
                      (.text (.select e "div.tips"))))
        {}
	(.select race-page "table#sc_sortBlock > tbody")))

(defn add-tips
  "add the number of tips to a collection of horses"
  [horses race-page]
	(map (fn [h] (assoc h :tips (Integer/valueOf (get (tips race-page) (.toUpperCase (:name h))))))
		horses))

(defn get-race
  "scrape a race page into a map of elements that we can work with"
  [race-page-f]
  (let [race (race-page-f)
        betting-forecast (first (.select race "div.info"))
        venue (.text (first (.select race "h1 > span")))
        time (.text (first (.select race "h1 > strong")))]
    {:venue venue
     :time time
     :runners (Integer/valueOf (get-runners race))
     :horses (add-tips (reduce (fn [coll f] (conj coll f)) (get-horses (get-odds betting-forecast) (get-horse-names betting-forecast) '())
                   (get-favourites (.getElementsByTag betting-forecast "b"))) race)}))

(defn get-horse-positions
  "get a map of horse names and finishing positions for a given date (assumes a string in yyyy-MM-dd format)"
  [date]
  (map
   (fn [element]
     (let [name (.text (.select element "a"))
           position (.text (.select element "sup"))]
       {:name name :position position}))
   (.select (.get (.timeout (Jsoup/connect (results-url date)) 60000)) "div#runner_index table.grid td.first")))

(defn get-all-race-urls
  "get all the race page URLs for today"
  []
  (get-race-urls page))

(defn race-pages
  "single-threaded version of scraping all today's races"
  []
  (for [url (get-all-race-urls)]
    (get-race (fn [] 
                (info (str "getting url: " url))
                (.get 
                 (.timeout
                  (Jsoup/connect (str racing-post-base-url url))
                  60000))))))

(defn multi-race-pages
  "multi-threaded version of scraping all today's races"
  []
  (let [r (ref [])
        pool  (Executors/newFixedThreadPool 20)
        tasks (map (fn [url]
                     (fn [] 
                       (dosync
                       (alter r conj 
                              (get-race (fn []
                                          (info (str "getting url: " url))
                                          (.get 
                                           (.timeout
                                            (Jsoup/connect (str racing-post-base-url url))
                                            60000))))))))
                   (get-all-race-urls))]
    (doseq [future (.invokeAll pool tasks)]
      (.get future))
    (.shutdown pool)
    (deref r)))