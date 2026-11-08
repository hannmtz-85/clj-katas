(ns katas.structures-test
  "Tests for lists, graphs, sorting, trees, hashing, recursion and design."
  (:require [clojure.test :refer [deftest is testing]]
            [katas.design :as d]
            [katas.graphs :as g]
            [katas.hashing :as h]
            [katas.lists :as l]
            [katas.recursion :as r]
            [katas.sorting :as s]
            [katas.trees :as t]))

;; --- lists ------------------------------------------------------------------

(defn- ->list [xs] (reduce (fn [next v] {:val v :next next}) nil (reverse xs)))
(defn- list->vec [node] (vec (take-while some? (map :val (take-while some? (iterate :next node))))))

(deftest add-numbers
  (is (= [4 7 2] (l/add-numbers [3 5 1] [1 2 1])))
  (is (= [1 2 8 9] (l/add-numbers [3 1 8] [9 7 1])))
  (is (= [1 0 0] (l/add-numbers [9 9] [1])))
  (is (= [1 0 0] (l/add-numbers [1] [9 9])))
  (is (= [0] (l/add-numbers [0] [0]))))

(deftest reverse-list
  (is (= [5 4 3 2 1] (list->vec (l/reverse-list (->list [1 2 3 4 5])))))
  (is (= [7] (list->vec (l/reverse-list (->list [7])))))
  (is (nil? (l/reverse-list nil))))

;; --- graphs -----------------------------------------------------------------

(defn- respects? [order primary dependent]
  (let [pos (zipmap order (range))]
    (every? (fn [[a b]] (< (pos a) (pos b))) (map vector primary dependent))))

(deftest task-order
  (let [primary [1 2 1] dependent [2 3 4] order (g/task-order primary dependent)]
    (is (= #{1 2 3 4} (set order)))
    (is (= 4 (count order)))
    (is (respects? order primary dependent)))
  (is (= [1] (g/task-order [1 2 3] [2 3 2])) "tasks in a cycle are left out")
  (is (= [] (g/task-order [] []))))

(deftest can-finish
  (is (true? (g/can-finish? [0] [1] 2)))
  (is (false? (g/can-finish? [0 1] [1 0] 2)))
  (is (true? (g/can-finish? [] [] 4)))
  (is (true? (g/can-finish? [0 1 2] [1 2 3] 4)))
  (is (false? (g/can-finish? [0 1 2] [1 2 0] 3))))

(def tree-graph {1 #{2 3} 2 #{4} 3 #{} 4 #{}})

(deftest bfs-order
  (is (= [1 2 3 4] (g/bfs-order tree-graph)))
  (is (= [] (g/bfs-order {})))
  (is (= [5] (g/bfs-order {5 #{}}))))

(deftest apply-modifiers
  (is (= [1 2 3 4] (g/apply-modifiers {1 #{2 3} 2 #{} 3 #{}} [[3 :add 4]])))
  (is (= [1 2 3] (g/apply-modifiers {1 #{2 3} 2 #{} 3 #{}} [[3 :add 4] [3 :remove 4]])) "applied in order")
  (is (= [1 2 3] (g/apply-modifiers {1 #{2 3} 2 #{} 3 #{}} [[99 :add 7]])) "unknown node ignored")
  (is (= [1 2 3] (g/apply-modifiers {1 #{2 3} 2 #{} 3 #{}} [[1 :add 2] [1 :remove 9]])) "no-ops")
  (is (= [1 3] (g/apply-modifiers {1 #{2 3} 2 #{} 3 #{}} [[1 :remove 2]]))))

;; --- sorting ----------------------------------------------------------------

(def arrays [[3 6 8 10 1 2 1] [5] [] [2 2 2] [9 8 7 6 5] [-3 4 0 -3]])

(deftest merge-sorted
  (is (= [1 2 3 4 5 6] (s/merge-sorted [1 3 5] [2 4 6])))
  (is (= [1 2] (s/merge-sorted [] [1 2])))
  (is (= [1 1 2] (s/merge-sorted [1 2] [1]))))

(deftest sorts
  (doseq [xs arrays]
    (is (= (vec (sort xs)) (s/merge-sort xs)) (str "merge-sort " xs))
    (is (= (vec (sort xs)) (s/quick-sort xs)) (str "quick-sort " xs)))
  (let [random (java.util.Random. 42)
        xs (vec (repeatedly 200 #(- (.nextInt random 50) 25)))]
    (is (= (vec (sort xs)) (s/merge-sort xs)))
    (is (= (vec (sort xs)) (s/quick-sort xs)))))

(deftest search-rotated
  (let [a [4 5 6 7 0 1 2]]
    (is (= 4 (s/search-rotated a 0)))
    (is (= -1 (s/search-rotated a 3)))
    (is (= 0 (s/search-rotated a 4)))
    (is (= 6 (s/search-rotated a 2))))
  (is (= 1 (s/search-rotated [3 1] 1)))
  (is (= 0 (s/search-rotated [1] 1)))
  (is (= -1 (s/search-rotated [] 1)))
  (testing "every rotation and every target agrees with a linear search"
    (let [sorted (mapv #(* 3 %) (range 1 13))]
      (doseq [k (range 12)
              :let [rotated (vec (concat (drop k sorted) (take k sorted)))]
              target (range 40)]
        (is (= (.indexOf ^java.util.List rotated target) (s/search-rotated rotated target)))))))

(deftest first-last
  (is (= [3 5] (s/first-last [5 7 7 8 8 8 10] 8)))
  (is (= [-1 -1] (s/first-last [5 7 7 8 8 8 10] 6)))
  (is (= [0 0] (s/first-last [5 7 7 8 8 8 10] 5)))
  (is (= [6 6] (s/first-last [5 7 7 8 8 8 10] 10)))
  (is (= [-1 -1] (s/first-last [] 1))))

;; --- trees ------------------------------------------------------------------

(defn- node ([v] {:val v}) ([v l r] {:val v :left l :right r}))

(def bst (node 8 (node 4 (node 2) (node 6 (node 5) (node 7))) (node 12)))

(deftest traversals
  (is (= [2 4 5 6 7 8 12] (t/inorder bst)))
  (is (= [8 4 2 6 5 7 12] (t/preorder bst)))
  (is (= [2 5 7 6 4 12 8] (t/postorder bst)))
  (is (= [] (t/inorder nil)))
  (is (= [] (t/preorder nil)))
  (is (= [] (t/postorder nil))))

(deftest bst-search
  (is (= 6 (:val (t/bst-search bst 6))))
  (is (nil? (t/bst-search bst 99)))
  (is (nil? (t/bst-search nil 1))))

(deftest valid-bst
  (is (true? (t/valid-bst? bst)))
  (is (true? (t/valid-bst? nil)))
  (is (false? (t/valid-bst? (node 8 (node 4 (node 2) (node 9)) (node 12)))) "9 is bigger than the root")
  (is (false? (t/valid-bst? (node 2 (node 2) nil))) "no repeated values")
  (is (true? (t/valid-bst? (node 0 (node Long/MIN_VALUE) (node Long/MAX_VALUE))))))

(deftest lowest-common-ancestor
  (is (= 8 (t/lowest-common-ancestor bst 2 12)))
  (is (= 6 (t/lowest-common-ancestor bst 5 7)))
  (is (= 4 (t/lowest-common-ancestor bst 2 7)))
  (is (= 4 (t/lowest-common-ancestor bst 4 6)))
  (is (= 8 (t/lowest-common-ancestor bst 5 12))))

;; --- hashing ----------------------------------------------------------------

(deftest two-sum
  (is (= [0 1] (h/two-sum [2 7 11 15] 9)))
  (is (= [2 3] (h/two-sum [11 15 7 2] 9)))
  (is (= [0 1] (h/two-sum [3 3] 6)))
  (is (= [0 2] (h/two-sum [1 1 5 5] 6)))
  (is (nil? (h/two-sum [1 2 3] 99))))

(deftest group-anagrams
  (is (= #{#{"eat" "tea" "ate"} #{"tan" "nat"} #{"bat"}}
         (set (map set (h/group-anagrams ["eat" "tea" "tan" "ate" "nat" "bat"])))))
  (is (empty? (h/group-anagrams []))))

;; --- recursion --------------------------------------------------------------

(deftest power-of-two
  (doseq [n [1 2 4 1024]] (is (true? (r/power-of-two? n)) (str n)))
  (doseq [n [6 0 -8 12]] (is (false? (r/power-of-two? n)) (str n))))

(deftest fibonacci
  (is (= [0 1 55] [(r/fibonacci 0) (r/fibonacci 1) (r/fibonacci 10)]))
  (is (= 2880067194370816120 (r/fibonacci 90))))

(deftest climb-stairs
  (is (= [1 2 3 34] (map r/climb-stairs [1 2 3 8])))
  (is (= 1836311903 (r/climb-stairs 45))))

;; --- design -----------------------------------------------------------------

(deftest lru
  (let [c (-> (d/lru-new 2) (d/lru-put 1 "one") (d/lru-put 2 "two"))
        [v c] (d/lru-get c 1)
        c (d/lru-put c 3 "three")]
    (is (= "one" v))
    (is (nil? (first (d/lru-get c 2))) "2 was the least recently used")
    (is (= "one" (first (d/lru-get c 1))))
    (is (= "three" (first (d/lru-get c 3))))))

(deftest lru-update-keeps-the-others
  (let [c (-> (d/lru-new 2) (d/lru-put 1 "one") (d/lru-put 2 "two") (d/lru-put 1 "uno"))]
    (is (= "uno" (first (d/lru-get c 1))))
    (is (= "two" (first (d/lru-get c 2))) "updating an existing key drops nobody")
    (let [c (d/lru-put c 3 "three")] ; 1 was updated last, so 2 is the least recently used and goes
      (is (= "uno" (first (d/lru-get c 1))))
      (is (nil? (first (d/lru-get c 2)))))))

(deftest rate-limiter
  (let [lim (d/limiter-new 3 10000)
        [a lim] (d/allow? lim :a 0)
        [b lim] (d/allow? lim :a 1)
        [c lim] (d/allow? lim :a 2)
        [e lim] (d/allow? lim :a 3)
        [other lim] (d/allow? lim :b 3)
        [late lim] (d/allow? lim :a 9999)
        [new-window lim] (d/allow? lim :a 10000)]
    (is (= [true true true false] [a b c e]))
    (is (true? other) "another client has its own count")
    (is (false? late) "still the first window")
    (is (true? new-window) "the window that began at 0 is over")))
