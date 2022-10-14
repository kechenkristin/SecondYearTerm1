myMap1 :: (a -> b) -> [a] -> [b]
myMap1 f xs = [f x | x <- xs]

myMap2 :: (a -> b) -> [a] -> [b]
myMap2 f [] = []
myMap2 f (x : xs) = f x : myMap2 f xs

myFilter1 :: (a -> Bool) -> [a] -> [a]
myFilter1 f xs = [x | x <- xs, f x]

myFilter2 :: (a -> Bool) -> [a] -> [a]
myFilter2 f [] = []
myFilter2 f (x : xs)
 | f x = x : myFilter2 f xs
 | otherwise = myFilter2 f xs
