(ns rover.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


; Position {:x :y :orientation}


(defn position-factory
  ([x y] {:x x :y y :orientation \N})
  ([x y orientation] {:x x :y y :orientation orientation})
  ;todo
  )

(defn turn-in-north
  [movement orientation]
  (if (= movement "l")
    \W
    \E)
  )


(defn move-in-y [movement y]
  (if (= movement "f")
    (inc y)
    (dec y))
  )

(defn parse-call
  [movement position]

  (let [y (:y position) x (:x position)]
  (if (= movement "")
    position
    (if (or (= movement "f") (= movement "b"))
      (position-factory x (move-in-y movement y))
      (if (or (= movement "l") (= movement "r"))
        (position-factory x y (turn-in-north movement position))
        (if (= movement "ff")
          (position-factory x (inc (inc y)))
          ; we've decided that an unknown command does do anything
          position))))))
