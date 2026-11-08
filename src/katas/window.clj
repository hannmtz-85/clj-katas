(ns katas.window
  "Sliding window.")

(defn candy-collector
  "A row of containers; `containers[i]` is the kind of candy in the i-th one. You have two baskets and each holds
  one kind. You choose where to start and walk to the right taking one candy from every container, including the
  first. You must stop at the first container whose candy would not fit in either basket. Return the most candies
  you can collect.

    (candy-collector [1 2 1])                          ;=> 3
    (candy-collector [1 2 3 2 2])                      ;=> 4
    (candy-collector [1 2 3 3 3 3 3 4 4 4 4 4 4])      ;=> 11"
  [containers]
  (throw (ex-info "Not solved yet" {})))

(defn longest-unique-substring
  "Return the longest substring of `s` with no repeated character (the first one, if several have that length), or
  an empty string.

    (longest-unique-substring \"abcabcbb\") ;=> \"abc\"
    (longest-unique-substring \"pwwkew\")    ;=> \"wke\""
  [s]
  (throw (ex-info "Not solved yet" {})))

(defn max-consecutive-ones
  "`bits` is a vector of 0s and 1s. You may flip at most `k` zeroes into ones. Return the length of the longest run
  of ones you can get.

    (max-consecutive-ones [1 1 0 0 1 1 1 0 1 1] 2) ;=> 7
    (max-consecutive-ones [0 0 0] 0)               ;=> 0"
  [bits k]
  (throw (ex-info "Not solved yet" {})))

(defn min-window
  "Return the shortest substring of `s` that contains every letter of `letters`, counting repeats (\"aa\" needs
  two a's), or an empty string if there is none. If several substrings tie for the shortest, return the leftmost.

    (min-window \"ADOBECODEBANC\" \"ABC\") ;=> \"BANC\"
    (min-window \"a\" \"aa\")              ;=> \"\""
  [s letters]
  (throw (ex-info "Not solved yet" {})))
