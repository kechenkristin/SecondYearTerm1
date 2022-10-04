-- quick sort
qsort :: Ord a => [a] -> [a]
qsort [] = []
qsort (x : xs) = qsort smaller ++ [x] ++ qsort larger
 where 
  smaller = [a | a <- xs, a <= x]
  larger = [b | b <- xs, b > x]


-- insert sort
myInsert :: Ord a => a -> [a] -> [a]
myInsert x [] = [x]
myInsert x (y : ys) 
 | x <= y = x : y : ys
 | otherwise = y : myInsert x ys

isort :: Ord a => [a] -> [a]
isort [] = []
isort (x : xs) = myInsert x (isort xs)

-- merge sort
myMerge :: Ord a => [a] -> [a] -> [a]
myMerge xs [] = xs
myMerge [] ys = ys
myMerge (x : xs) (y : ys)
 | x <= y = x : myMerge xs (y : ys)
 | otherwise = y : myMerge (x : xs) ys

msort :: Ord a => [a] -> [a] 
msort [] = []
msort [x] = [x]
msort xs = myMerge (msort ys) (msort zs)
 where 
 (ys, zs) = half xs
