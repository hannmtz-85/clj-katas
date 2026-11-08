(ns katas.design
  "Small data structures with state. Clojure values are immutable, so each operation takes the structure and
  returns the new one (with its answer when it has one).")

;; ---------------------------------------------------------------------------
;; An LRU cache: when it is full, the least recently used key goes.

(defn lru-new
  "An empty LRU cache that holds at most `capacity` keys (capacity >= 1)."
  [capacity]
  (throw (ex-info "Not solved yet" {})))

(defn lru-get
  "Return `[value cache']`. The value is nil when the key is not there. Reading a key makes it the most recently
  used.

  It must not take longer as the cache grows: no scan of all the keys."
  [cache k]
  (throw (ex-info "Not solved yet" {})))

(defn lru-put
  "Return the cache with `k` bound to `v` and most recently used. If the cache was full and `k` is new, the least
  recently used key is dropped first. Updating an existing key never drops another."
  [cache k v]
  (throw (ex-info "Not solved yet" {})))

;; ---------------------------------------------------------------------------
;; A fixed-window rate limiter.

(defn limiter-new
  "A rate limiter that lets each client make `limit` requests in each window of `window-ms` milliseconds. The
  window of a client starts at its first request and a new one starts at the first request after the window ends."
  [limit window-ms]
  (throw (ex-info "Not solved yet" {})))

(defn allow?
  "Return `[allowed? limiter']` for a request of `client` at the time `now-ms` (milliseconds; times never go
  back). A refused request does not count."
  [limiter client now-ms]
  (throw (ex-info "Not solved yet" {})))
