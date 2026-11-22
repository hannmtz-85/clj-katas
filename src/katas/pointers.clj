(ns katas.pointers
  "Fast and slow pointers, and two pointers.")

(defn duplicate-number
  "`nums` holds n + 1 integers, every one of them between 1 and n. Exactly one value appears more than once
  (it may appear many times). Return it.

  Think of each number as the index of the next one to visit. Aim for O(n) time and O(1) extra space.

    (duplicate-number [1 3 4 2 2]) ;=> 2
    (duplicate-number [3 1 3 4 2]) ;=> 3
    (duplicate-number [3 3 3 3 3]) ;=> 3"
  [nums]
  (loop [slow (nums 0)
         fast (nums slow)]
    (if (= slow fast)
      (loop [i 0
             j slow]
        (if (= i j)
          i
          (recur (nums i)
                 (nums j))))
      (recur (nums slow)
             (nums (nums fast))))))

(defn happy?
  "Replace a positive number by the sum of the squares of its digits, and repeat. If the process reaches 1 the
  number is happy; otherwise it loops for ever. Say whether `n` is happy. Numbers below 1 are not happy.

    (happy? 19) ;=> true   (19 -> 82 -> 68 -> 100 -> 1)
    (happy? 2)  ;=> false"
  [n]
  (letfn [(sum-square [x]
            (loop [m x
                   result 0]
              (if (= m 0)
                result
                (let [digit (rem m 10)]
                  (recur (quot m 10)
                         (+ result (* digit digit)))))))]
    (and (> n 0)
         (loop [slow (sum-square n)
                fast (sum-square slow)]
           (if (= slow fast)
             (= slow 1)
             (recur (sum-square slow)
                    (-> fast sum-square sum-square)))))))

(defn move-zeroes
  "Return the vector `nums` with every 0 moved to the end and the other numbers in their original order.

    (move-zeroes [0 1 0 3 12]) ;=> [1 3 12 0 0]
    (move-zeroes [0])          ;=> [0]"
  [nums]
  (->> (range (count nums))
       (reduce (fn [{:keys [v z] :as state} i]
                 (if (zero? (v i))
                   state
                   {:v (assoc v
                              z (v i)
                              i (v z))
                    :z (inc z)}))
               {:v nums :z 0})
       (:v)))

(defn two-sum-sorted
  "`nums` is sorted in ascending order. Return `[i j]`, with i < j, such that the numbers at those indexes add up
  to `target`, or nil when there are none. Use the order: O(n) time and O(1) extra space.

    (two-sum-sorted [2 7 11 15] 9) ;=> [0 1]
    (two-sum-sorted [1 2 3] 100)   ;=> nil"
  [nums target]
  (loop [i 0
         j (- (count nums) 1)]
    (if
     (<= j i) nil
     (let [sum (+ (nums i) (nums j))]
       (cond
         (= sum target) [i j]
         (> sum target) (recur i (dec j))
         :else (recur (inc i) j))))))

(defn valid-palindrome-2?
  "Say whether the string `s` is a palindrome, or becomes one after deleting at most one character.

    (valid-palindrome-2? \"abca\")   ;=> true
    (valid-palindrome-2? \"xabcba\") ;=> true
    (valid-palindrome-2? \"abc\")    ;=> false"
  [s]
  (letfn [(is-palindrome [s i j]
            (loop [start i
                   end j]
              (cond
                (> start end) true
                (not= (get s start) (get s end)) false
                :else (recur (inc start) (dec end)))))]
    (loop [i 0
           j (-> s count dec)]
      (cond
        (> i j) true
        (= (get s i) (get s j)) (recur (inc i) (dec j))
        :else (or (is-palindrome s (inc i) j)
                  (is-palindrome s i (dec j)))))))


(comment

  (deref (future (duplicate-number [1 3 4 2 2])) 2000 :timeout)

  (duplicate-number [2 4 4 4 3 5])
  (duplicate-number [1 3 4 2 2]) ;=> 2
  (duplicate-number [3 1 3 4 2]) ;=> 3
  (duplicate-number [3 3 3 3 3]) ;=> 3"
  
  )