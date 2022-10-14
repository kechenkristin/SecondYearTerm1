-- Return a list of all possible ways of splitting a list into two non-empty parts
-- > split [1, 2, 3, 4]
-- [([1], [2, 3, 4]), ([1, 2], [3, 4]), ([1, 2, 3], [4])]

split :: [a] -> [([a], [a])]
split xs = split1 xs 0


split1 :: [a] -> Int -> [([a], [a])]
split1 xs (length xs) = []
split xs = [(zip ys zs) | ys <- (take (n + 1) xs), zs <- (drop (n + 1) xs)]



