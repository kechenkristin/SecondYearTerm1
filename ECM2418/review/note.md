### Haskell
Num Eq Ord  
```haskell
myContains :: Eq a => [a] -> a -> Bool
myContains [] y = False
myContains (x : xs) y
 | x == y = True
 | otherwise = myContains xs y

mySet :: Eq a => [a] -> Bool
mySet [] = False
mySet (x : xs)
 | contains x xs = False
 | otherwise = mySet xs
```
