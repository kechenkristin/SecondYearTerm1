-- ch2
double x = x + x
quadruple x = double (double x)

factorial n = product [1..n]
average ns = sum ns `div` length ns

-- ch3
add1 :: (Int, Int) -> Int
add1 (x, y) = x + y

add2 :: Int -> (Int -> Int)
add2 x y = x + y

-- lab1
myLen :: [a] -> Int
myLen [] = 0
myLen (_: xs) = 1 + myLen xs

myContains :: Eq a => [a] -> a -> Bool
myContains [] y = False
myContains (x : xs) y 
 | x == y = True
 | otherwise = myContains xs y

-- look
mySet :: Eq a => [a] -> Bool
mySet [] = False
mySet (x : xs) 
 | myContains xs x = False 
 | otherwise = mySet xs

-- look
myLargest :: Ord a => [a] -> a 
myLargest [x] = x
mylargest (x : xs) = max x (myLargest xs)

myZip :: [a] -> [b] -> [(a, b)]
myZip _ [] = []
myZip [] _ = []
myZip (x : xs) (y : ys) = (x, y) : myZip xs ys

myInsert :: Ord a => a -> [a] -> [a]
myInsert y (x : xs)
 | y < x = y : x : xs
 | otherwise = x : myInsert y xs

iSort :: Ord a => [a] -> [a]
iSort [] = []
iSort (x : xs) = myInsert x (iSort xs)

-- lab2
memberSet :: Eq a => a -> [a] -> Bool
memberSet _ [] = False
memberSet y (x : xs) 
 | y == x = True
 | otherwise = memberSet y xs

unionSet :: Eq a => [a] -> [a] -> [a]
unionSet [] ys = ys
unionSet xs [] = xs
unionSet (x : xs) ys 
 | memberSet x ys = unionSet xs ys
 | otherwise = x : unionSet xs ys

intersectSet :: Eq a => [a] -> [a] -> [a]
intersectSet [] _ = []
intersectSet _ [] = []
intersectSet (x : xs) ys 
 | memberSet x ys = x : intersectSet xs ys
 | otherwise = intersectSet xs ys

takeList :: Int -> [a] -> [a]
takeList 0 xs = []
takeList _ [] = []
takeList n (x : xs) = x : takeList (n - 1) xs

dropList :: Int -> [a] -> [a]
dropList 0 xs = xs
dropList _ [] = []
dropList n (x : xs) = dropList (n - 1) xs

-- look
splitList :: Int -> [a] -> ([a], [a])
splitList n xs = ((takeList n xs), (dropList n xs))


-- appList
appList :: [a] -> [a] -> [a]
appList [] xs = xs
appList (x : xs) ys = x : appList xs ys

-- look
-- appList xs ys = foldr (:) ys xs 

-- look
concatList :: [[a]] -> [a]
concatList [] = []
concatList (x : xs) = x ++ concatList xs

concatList1 :: [[a]] -> [a]
concatList1 xss = [x | xs <- xss, x <- xs]

concatList2 :: [[a]] -> [a]
concatList2 = foldr (++) [] 

-- look
triangle :: Int -> Int
triangle x = x * (x + 1) `div` 2

triangles :: [Int] -> [Int]
triangles xs = map triangle xs

triangles2 :: [Int] -> [Int]
triangles2 xs = [ x * (x + 1) `div` 2 | x <- xs]
