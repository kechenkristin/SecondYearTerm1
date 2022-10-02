pyths :: Int -> [(Int, Int, Int)]

pyths n = [(x, y, n) | x <- [1..n], y <- [1..n], x^2 + y^2 == n^2]

factors :: Int -> [Int]

factors n = [x | x <- [1..n], mod n x == 0]

perfect :: Int -> Bool

perfect n = sum (factors n) - n == n

perfects :: Int -> [Int]

perfects n = [x | x <- [1..n], perfect x]

sp :: [Int] -> [Int] -> Int

sp xs ys = sum [ x * y | (x, y) <- zip xs ys]

sp2 :: [Int] -> [Int] -> Int

sp2 xs ys = sum [xs !! i * ys !! i | i <- [1..n]]
 where n = length xs
