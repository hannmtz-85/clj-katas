(ns katas.stacks
  "Stacks.")

(defn simplify-path
  "`path` is an absolute Unix path. Return its canonical form:

  - `.` is the current directory and is dropped; `..` goes up one directory (at the root it stays at the root);
  - several slashes in a row are one slash;
  - any other run of dots, such as `...`, is an ordinary name;
  - the result starts with one slash, has one slash between names and no slash at the end (except the root).

    (simplify-path \"/home/../usr//bin/./vim\") ;=> \"/usr/bin/vim\"
    (simplify-path \"/../\")                    ;=> \"/\""
  [path]
  (throw (ex-info "Not solved yet" {})))

(defn balanced?
  "Say whether every bracket of `()`, `[]` and `{}` in `s` is closed by the right kind, in the right order. Other
  characters are not brackets; an empty string is balanced.

    (balanced? \"([{}])\") ;=> true
    (balanced? \"([)]\")   ;=> false"
  [s]
  (throw (ex-info "Not solved yet" {})))
