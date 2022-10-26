-- sequential maximum function
seqmax :: [Int] -> Int
seqmax [x] = x
seqmax (x : xs)
 | x > seqmax xs = x
 | otherwise = seqmax xs

-- divide-and-conquer maximum function
dcmax :: [Int] -> Int
dcmax [x] = x
dcmax xs = max (dcmax left) (dcmax right)
 where 
  mid = div (length xs) 2
  (left, right) = splitAt mid xs

-- parallel divide-and-conquer maximum funtion


-- sequential sort function
myInsert :: Int -> [Int] -> [Int]
myInsert x [] = [x]
myInsert x (y : ys)
 | x <= y = x : y : ys
 | otherwise = y : myInsert x ys

seqsort :: [Int] -> [Int] 
seqsort [] = []
seqsort (x : xs) = myInsert x (seqsort xs)

-- Write a “part” function that takes a predicate and a list of values, and returns the pair of lists of values which do and do not satisfy the predicate, respectively
-- part (< 8) [3,7,10,9] ====> ([3,7], [10,9])
-- part :: Bool -> [Int] -> ([Int], [Int])
part :: (Int -> Bool) -> [Int] -> ([Int], [Int])
part p [] = ([], [])
part p (x : xs) 
 | p x = (x : as, bs)
 | otherwise = (as, x : bs)
 where
  (as, bs) = part p xs

qsort :: [Int] -> [Int]
qsort [] = []
qsort (x : xs) = qsort left ++ [x] ++ qsort right
 where
  left = [a | a <- xs, a <= x]
  right = [b | b <- xs, b > x]

qsort2 [] = []
qsort2 (x : xs) = qsort2 left ++ [x] ++ qsort2 right
 where
  (left, right) = part (<x) xs
