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
  (throw (ex-info "Not solved yet" {})))

(defn happy?
  "Replace a positive number by the sum of the squares of its digits, and repeat. If the process reaches 1 the
  number is happy; otherwise it loops for ever. Say whether `n` is happy. Numbers below 1 are not happy.

    (happy? 19) ;=> true   (19 -> 82 -> 68 -> 100 -> 1)
    (happy? 2)  ;=> false"
  [n]
  (throw (ex-info "Not solved yet" {})))

(defn move-zeroes
  "Return the vector `nums` with every 0 moved to the end and the other numbers in their original order.

    (move-zeroes [0 1 0 3 12]) ;=> [1 3 12 0 0]
    (move-zeroes [0])          ;=> [0]"
  [nums]
  (throw (ex-info "Not solved yet" {})))

(defn two-sum-sorted
  "`nums` is sorted in ascending order. Return `[i j]`, with i < j, such that the numbers at those indexes add up
  to `target`, or nil when there are none. Use the order: O(n) time and O(1) extra space.

    (two-sum-sorted [2 7 11 15] 9) ;=> [0 1]
    (two-sum-sorted [1 2 3] 100)   ;=> nil"
  [nums target]
  (throw (ex-info "Not solved yet" {})))

(defn valid-palindrome-2?
  "Say whether the string `s` is a palindrome, or becomes one after deleting at most one character.

    (valid-palindrome-2? \"abca\")   ;=> true
    (valid-palindrome-2? \"xabcba\") ;=> true
    (valid-palindrome-2? \"abc\")    ;=> false"
  [s]
  (throw (ex-info "Not solved yet" {})))
