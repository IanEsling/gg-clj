(ns gg-clj.mail
  (:use [clojure.string :exclude [reverse replace]]))

(defn emailable-race [race]
    (assoc race :bettable (< 0 (count
							(filter #(let [	components (for [s (split % #"/")] (read-string s))
        									odds (/ (first components) (second components))]
										(and (>= 2 odds) (<= 1 odds)))
							(map #(:odds %) (:horses race)))))))