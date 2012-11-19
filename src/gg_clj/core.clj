(ns gg-clj.core
	(:gen-class)
	(:use gg-clj.web)
  	(:use gg-clj.db))

(defn save-races []
	(create-race-day (race-pages)))

(defn -main
  "I don't do a whole lot."
  [& args]
	(save-races))

