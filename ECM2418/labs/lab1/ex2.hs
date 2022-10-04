myZip :: [a] -> [b] -> [(a, b)]
myZip [] _ = []
myZip _ [] = []
myZip (x : xs) (y : ys) = (x, y) : myZip xs ys

myInsert x [] = [x]
myInsert y (x : xs)
 | y < x = y : x : xs
 | otherwise = x : myInsert y xs

isort :: Ord a => [a] -> [a]
isort [] = []
isort (x : xs) = myInsert x (isort xs)
