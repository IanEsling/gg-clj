(defproject gg-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :main gg-clj.core
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.jsoup/jsoup "1.7.1"]
                 [korma "0.3.0-beta11"]
		 [postgresql "9.0-801.jdbc4"]
                 [joda-time/joda-time "2.1"]
                 [org.clojure/tools.logging "0.2.3"]
                 [clj-logging-config "1.9.10"]
                 [hiccup "1.0.2"]
                 [com.draines/postal "1.9.0"]
                 [ring/ring-jetty-adapter "1.1.6"]
                 [compojure "1.1.3"]
                 ]
  :profiles {:dev
             {:dependencies [[midje "1.4.0"]
                             [ring/ring-devel "0.3.7"] ]}})
