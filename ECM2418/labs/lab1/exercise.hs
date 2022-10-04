myLen :: [a] -> Int
myLen [] = 0
myLen (_ : xs ) = 1 + myLen xs

myContains :: Eq a => [a] -> a -> Bool
myContains [] y = False
myContains (x : xs) y 
 | x == y = True
 | otherwise =  myContains xs y

-- returns ture if there are replicate in the list
mySet :: Eq a => [a] -> Bool
mySet [] = True
mySet (x : xs) = (myContains xs x) && mySet xs

myLargest :: [Int] -> Int
myLargest [x] = x
myLargest (x : xs) 
 | x > myLargest xs = x
 | otherwise largest xs
