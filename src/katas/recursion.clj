(ns katas.recursion
  "Recursion, memoization and dynamic programming.")

(defn power-of-two?
  "Say whether the integer `n` is a power of two (1, 2, 4, 8, ...). Zero and negative numbers are not.

  Bonus: do it with one bit operation."
  [n]
  (throw (ex-info "Not solved yet" {})))

(defn fibonacci
  "The n-th Fibonacci number, with (fibonacci 0) = 0 and (fibonacci 1) = 1. It must answer `(fibonacci 90)` at
  once, so a plain double recursion is too slow: remember what you have computed, or build it bottom-up.

    (fibonacci 10) ;=> 55"
  [n]
  (throw (ex-info "Not solved yet" {})))

(defn climb-stairs
  "Ways to climb a staircase of `n` steps (n >= 1) taking one or two steps at a time.

    (climb-stairs 3) ;=> 3
    (climb-stairs 8) ;=> 34

  Bonus: use O(1) extra space."
  [n]
  (throw (ex-info "Not solved yet" {})))
