myAnd :: [Bool] -> Bool
myAnd [] = True
myAnd (x : xs) = x && myAnd xs

myConcat :: [[a]] -> [a]
myConcat [] = []
myConcat (x : xs) = x ++ myConcat xs

myConcat2 :: [[a]] -> [a]
myConcat2 xss = [x | xs <- xss, x <- xs]

-- produce a list with n identical elements
myReplicate :: Int -> a -> [a]
myReplicate 0 x = []
myReplicate n x = [x] ++ myReplicate (n - 1) x

-- select the nth element of a list
mySelect :: [a] -> Int -> a
mySelect (x : xs) 0 = x
mySelect (x : xs) n = mySelect xs (n - 1)

-- decide if a value is an element of a list
myElem :: Eq a => a -> [a] -> Bool
myElem y [] = False
myElem y (x : xs)  
 | y == x = True
 | otherwise =  myElem y xs
