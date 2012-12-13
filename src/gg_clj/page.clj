(ns gg-clj.page
  (:use hiccup.core))

(defn subs-miss-end
  "returns a string with the last char substringed out"
  [s]
  (if (< 0 (count s)) (subs s 0 (- (count s) 1)) s))

(defn finishes [results]
  (apply str
         (for [finish (:finishes results)]
           (str "{"
                "finish : " (:finish finish) ","
                "name : '" (:name finish) "'"
                ","
                "venue : '" (:venue finish) "'"
                ",time : '" (:time finish) "'"
                ",mn : '" (:magic-number finish) "'"
                "},"))))

(defn first-race-date-in-millis
  "gets earliest race date in millis"
  [race-day-results]
  (reduce (fn [t n]
            (prn t n)
            (if (< t n) t n)) (.getTime (java.util.Date.))
          (map :race_date race-day-results)))

(defn chart-data
  "mung the result data into a comma separated list for the chart data in the HTML page"
  [race-day-results]
  
  (def data (apply str (for [result race-day-results]
                         (str "{y : " (:total result)
                              ", finishes : [" (subs-miss-end (finishes result))
                              "]},"))))
  (prn "chart data:" data)
  (subs-miss-end data))

(defn chart-series
  "produce the series for the chart configuration, produce a different series for each running total passed in"
  [running-totals]
  (subs-miss-end (apply str
                        (for [running-total running-totals]
                          (str "{
                name: '"
                               (:title running-total)
                               "',
                pointInterval: 24 * 3600 * 1000,
                pointStart: "
                               (first-race-date-in-millis (:value running-total))
                               ",
                data: ["
                               (chart-data (:value running-total))
                               "]},"
                               )))))
             


(defn index
  "HTML for betting page"
  [running-totals]
    (html [:html 
           (html [:head [:link {:href "/css/gg.css" :media "screen" :rel "stylesheet" :type "text/css"}]
                  [:script {:type "text/javascript" :src "http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"}]
                  [:script {:type "text/javascript" :src "/js/highcharts.js"}]
                  [:script {:type "text/javascript"}
                   (str "$(function () {
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container',
                marginRight: 130,
                marginBottom: 25,
                type: 'spline'
            },
            title: {
                text: 'Betting Points',
                x: -20 //center
            },
            subtitle: {
                text: '',
                x: -20
            },
            tooltip: {
                formatter: function() {
                var s = '';
                for (var i=0,len=this.point.finishes.length; i<len; i++)
                {
                   s = s + '<b>' + this.point.finishes[i].finish + '</b> ' + this.point.finishes[i].time + ' ' + this.point.finishes[i].venue + ' ' + this.point.finishes[i].name + ' ' + this.point.finishes[i].mn + '<br/>'
                }
                if (s == '')
                {
                  return 'No Bet.';
                } else
                {  
                return s;
                }
             }
            },
            xAxis: {
                type: 'datetime'
                },
            yAxis: {
                title: {
                    text: 'Number of Points'
                },
                plotLines: [{
                    value: 0,
                    width: 1,
                    color: '#808080'
                }]
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -10,
                y: 100,
                borderWidth: 0
            },
            series: ["
                        (chart-series running-totals)
         "]});
    });
    
});")]])
           (html [:body
                  (html [:div {:id "container"}])])]))
