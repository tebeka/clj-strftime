(ns strftime-test
  (:use clojure.test
        strftime)
  (:import java.util.Date
           java.util.Calendar))

; Months are 0 based, go figure ...
(def c (doto (Calendar/getInstance) (.set 2012 10 10 9 8 0)))
(def result "2012/11/10 09:08")
(def fmt "%Y/%m/%d %H:%M")

(deftest calendar-test
  (testing "Calendar"
    (is (= (strftime fmt c) result))))

(deftest date-test
  (testing "Calendar"
    (is (= (strftime fmt (.getTime c)) result))))

(deftest date-long
  (testing "long"
    (is (= (strftime fmt (.getTimeInMillis c)) result))))
