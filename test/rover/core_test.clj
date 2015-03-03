(ns rover.core-test
  (:require [clojure.test :refer :all]
            [rover.core :refer :all]))

(deftest mars-rover
  (testing "An empty order movements call returns initial position"
    (def initialPosition (position-factory 0 1))
    (def emptyMovements "")
    (is (= initialPosition (parse-call emptyMovements initialPosition))))

  (testing "Forward advances one"
    (def initialPosition (position-factory 0 0))
    (def expectedFinalPosition (position-factory 0 1))
    (def simpleForwardMovement "f")
    (is (= expectedFinalPosition (parse-call simpleForwardMovement initialPosition))))

  (testing "Backwards retrocedes one"
    (def initialPosition (position-factory 0 0))
    (def expectedFinalPosition (position-factory 0 -1))
    (def backwards-movement "b")
    (is (= expectedFinalPosition (parse-call backwards-movement initialPosition))))

  (testing "Turn right"
    (def initialPosition (position-factory 0 0))
    (def expectedPosition (position-factory 0 0 \E))
    (def movements "r")
    (is (= expectedPosition (parse-call movements initialPosition))))

  (testing "Turn left"
    (def initialPosition (position-factory 0 0))
    (def expectedPosition (position-factory 0 0 \W))
    (def movements "l")
    (is (= expectedPosition (parse-call movements initialPosition))))

  (testing "Forward-Forward"
    (def initialPosition (position-factory 0 0))
    (def expectedPosition (position-factory 0 2))
    (def movements "ff")
    (is (= expectedPosition (parse-call movements initialPosition))))

  (testing "move forward in y from nonzero"
    (is (= 2 (move-in-y "f" 1))))

  (testing "move backwards in y from nonzero"
    (is (= 0 (move-in-y "b" 1))))

  (testing "Forward from non-zero"
    (def initialPosition (position-factory 0 2))
    (def expectedPosition (position-factory 0 3))
    (def movements "f")
    (is (= expectedPosition (parse-call movements initialPosition))))

  (testing "Turn right from non-zero position"
    (def initialPosition (position-factory 0 2))
    (def expectedPosition (position-factory 0 2 \E))
    (def movements "r")
    (is (= expectedPosition (parse-call movements initialPosition))))

  (testing "Forwards from non-central position "
    (def initialPosition (position-factory 1 0))
    (def expectedPosition (position-factory 1 1))
    (def movements "f")
    (is (= expectedPosition (parse-call movements initialPosition))))

  (testing "Turn right from non-central position"
    (def initialPosition (position-factory 1 2))
    (def expectedPosition (position-factory 1 2 \E))
    (def movements "r")
    (is (= expectedPosition (parse-call movements initialPosition))))

  (testing "Forward-Forward from non central position"
    (def initialPosition (position-factory 2 1))
    (def expectedPosition (position-factory 2 3))
    (def movements "ff")
    (is (= expectedPosition (parse-call movements initialPosition))))


  )



