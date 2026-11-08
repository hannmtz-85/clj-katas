(ns katas.arrays-test
  "Tests for pointers, window, stacks and greedy."
  (:require [clojure.test :refer [deftest is testing]]
            [katas.greedy :as greedy]
            [katas.pointers :as p]
            [katas.stacks :as stacks]
            [katas.window :as w]))

(deftest duplicate-number
  (is (= 2 (p/duplicate-number [1 3 4 2 2])))
  (is (= 3 (p/duplicate-number [3 1 3 4 2])))
  (is (= 3 (p/duplicate-number [3 3 3 3 3])))
  (is (= 1 (p/duplicate-number [1 1])))
  (is (= 1 (p/duplicate-number [1 2 3 4 5 6 1]))))

(deftest happy
  (doseq [n [1 7 19 100]] (is (true? (p/happy? n)) (str n)))
  (doseq [n [2 4 0 -5]] (is (false? (p/happy? n)) (str n))))

(deftest move-zeroes
  (is (= [1 3 12 0 0] (p/move-zeroes [0 1 0 3 12])))
  (is (= [0] (p/move-zeroes [0])))
  (is (= [1 2 3] (p/move-zeroes [1 2 3])))
  (is (= [] (p/move-zeroes [])))
  (is (= [4 0 0 0] (p/move-zeroes [0 0 0 4]))))

(deftest two-sum-sorted
  (is (= [0 1] (p/two-sum-sorted [2 7 11 15] 9)))
  (is (= [1 2] (p/two-sum-sorted [1 2 4 9] 6)))
  (is (nil? (p/two-sum-sorted [1 2 3] 100)))
  (is (nil? (p/two-sum-sorted [] 1)))
  (is (nil? (p/two-sum-sorted [5] 10))))

(deftest valid-palindrome-2
  (doseq [s ["abca" "xabcba" "aba" "" "a" "ab"]]
    (is (true? (p/valid-palindrome-2? s)) s))
  (doseq [s ["abc" "abcd"]]
    (is (false? (p/valid-palindrome-2? s)) s)))

(deftest candy-collector
  (is (= 3 (w/candy-collector [1 2 1])))
  (is (= 3 (w/candy-collector [0 1 2 2])))
  (is (= 4 (w/candy-collector [1 2 3 2 2])))
  (is (= 11 (w/candy-collector [1 2 3 3 3 3 3 4 4 4 4 4 4])))
  (is (= 1 (w/candy-collector [7])))
  (is (= 0 (w/candy-collector []))))

(deftest longest-unique-substring
  (is (= "abc" (w/longest-unique-substring "abcabcbb")))
  (is (= "b" (w/longest-unique-substring "bbbbb")))
  (is (= "wke" (w/longest-unique-substring "pwwkew")))
  (is (= "" (w/longest-unique-substring ""))))

(deftest max-consecutive-ones
  (is (= 7 (w/max-consecutive-ones [1 1 0 0 1 1 1 0 1 1] 2)))
  (is (= 3 (w/max-consecutive-ones [1 1 1] 0)))
  (is (= 1 (w/max-consecutive-ones [0 0 0] 1)))
  (is (= 0 (w/max-consecutive-ones [0 0 0] 0))))

(deftest min-window
  (is (= "BANC" (w/min-window "ADOBECODEBANC" "ABC")))
  (is (= "a" (w/min-window "a" "a")))
  (is (= "" (w/min-window "a" "aa")))
  (is (= "" (w/min-window "abc" "d")))
  (is (= "aab" (w/min-window "aaabaaa" "aab")) "\"aab\" and \"aba\" tie: the leftmost wins"))

(deftest simplify-path
  (is (= "/usr/bin/vim" (stacks/simplify-path "/home/../usr//bin/./vim")))
  (is (= "/" (stacks/simplify-path "/../")))
  (is (= "/c" (stacks/simplify-path "/a/./b/../../c/")))
  (is (= "/" (stacks/simplify-path "/")))
  (is (= "/..." (stacks/simplify-path "/.../")))
  (is (= "/a/b" (stacks/simplify-path "///a//b///"))))

(deftest balanced
  (doseq [s ["([{}])" "" "()[]{}" "a(b)c"]] (is (true? (stacks/balanced? s)) s))
  (doseq [s ["(]" "([)]" "((" ")" "{[}"]] (is (false? (stacks/balanced? s)) s)))

(deftest candy-distribution
  (is (= {:candies [1 3 2 1] :total 7} (greedy/candy-distribution [1 5 3 2])))
  (is (= 6 (:total (greedy/candy-distribution [1 2 2 1]))))
  (is (= {:candies [1 1 1] :total 3} (greedy/candy-distribution [4 4 4])))
  (is (= {:candies [1 2 3] :total 6} (greedy/candy-distribution [1 2 3])))
  (is (= {:candies [3 2 1] :total 6} (greedy/candy-distribution [3 2 1])))
  (is (= {:candies [] :total 0} (greedy/candy-distribution []))))

(deftest can-reach-end
  (is (true? (greedy/can-reach-end? [2 3 1 1 4])))
  (is (false? (greedy/can-reach-end? [3 2 1 0 4])))
  (is (true? (greedy/can-reach-end? [0])))
  (is (true? (greedy/can-reach-end? [1 0])))
  (is (false? (greedy/can-reach-end? [0 1]))))
