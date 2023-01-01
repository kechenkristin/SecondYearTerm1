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
