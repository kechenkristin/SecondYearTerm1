myLen :: [a] -> Int
myLen [] = 0
myLen (_ : xs ) = 1 + myLen xs

myContains :: Eq a => [a] -> a -> Bool
myContains [] _ = False
myContains (x : xs) y 
 | x == y = True
 | otherwise =  myContains xs y

-- returns ture if there are replicate in the list
mySet :: Eq a => [a] -> Bool
mySet [] = True
mySet (x : xs) 
 | myContains xs x = False
 | otherwise = mySet xs

myLargest :: Ord a => [a] -> a
myLargest [x] = x
myLargest (x : xs) = max x (myLargest xs)

myZip :: [a] -> [b] -> [(a, b)]
myZip [] _ = []
myZip _ [] = []
myZip (x : xs) (y : ys) = (x, y) : myZip xs ys

myZipped :: ([a], [b]) -> [(a, b)]
myZipped ([], _) = []
myZipped (_, []) = []
myZipped ((x : xs), (y : ys)) = (x, y) : myZipped (xs, ys)

myInsert :: Ord a => a -> [a] -> [a]
myInsert x [] = [x]
myInsert x (y : ys)
 | x <= y = x : y : ys
 | otherwise = y : myInsert x ys

isort :: Ord a => [a] -> [a]
isort [] = []
isort (x : xs) = myInsert x (isort xs)
