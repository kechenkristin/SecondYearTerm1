memberSet :: Eq a => a -> [a] -> Bool
memberSet n [] = False
memberSet n (x : xs)
 | n == x = True
 | otherwise = memberSet n xs

unionSet :: Eq a => [a] -> [a] -> [a]
unionSet xs [] = xs
unionSet [] ys = ys
unionSet (x : xs) ys
 | memberSet x ys = unionSet xs ys
 | otherwise = x : unionSet xs ys

intersectSet :: Eq a => [a] -> [a] -> [a]
intersectSet xs [] = []
intersectSet [] ys = []
intersectSet (x : xs) ys
 | memberSet x ys = x : intersectSet xs ys
 | otherwise = intersectSet xs ys

takeList :: Int -> [a] -> [a]
takeList n [] = []
takeList 0 _ = []
takeList n (x : xs) = x : takeList (n - 1) xs

dropList :: Int -> [a] -> [a]
dropList n [] = []
dropList 0 xs = xs
dropList n (x : xs) = dropList (n-1) xs

mySplit :: Int -> [a] -> ([a], [a])
mySplit n xs = ((takeList n xs), (dropList n xs))
