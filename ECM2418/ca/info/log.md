### Development Log for ECM2418's CA

#### version1
acceptables: [([5,2,1,3,4,7,6],[8,9]),([7,9,4],[5,2,6,8,3,1]),([7,1,6,3],[5,9,2,4,8]),([5,9,2,4,8],[7,1,6,3]),([8,9],[5,2,1,3,4,7,6]),([5,2,6,8,3,1],[7,9,4])]
 
0: 5213476 * 89 = 463999364

1: 794 * 526831 = 418303814

2: 7163 * 59248 = 424393424

#### version2(seems to be correct)
##### Q1 when compiling, the speed is pretty slow, do we need to use any techniques to speed up?

##### Q2 question: what does the last digit of the smallest number mean?
result from using relatively smaller
[([5,2,1,3,4,7,6],[8,9]),([7,1,6,3],[5,9,2,4,8]),([5,9,2,4,8],[7,1,6,3]),([8,9],[5,2,1,3,4,7,6])]


```
424393424 -- 3
418303814 -- 0
463999364 -- 3
12321 -- 1
78387 -- 3
```

```
*Main> findSmall [3, 8, 7]
3
*Main> findSmall [3, 8, 7]
3
*Main> findSmall [3, 2, 1]
1
*Main> findSmall [9, 9, 9, 3, 6, 4]
3
*Main> findSmall [0, 3, 8, 1, 4]
0
*Main> findSmall [9, 3, 4, 2, 4]
3

```

```haskell
digits :: Int -> [Int]
digits = map (read . (:[])) .show

isPalindrome :: [Int] -> Bool
isPalindrome xs = xs == reverse xs

cutHalf :: [Int] -> [Int]
cutHalf [] = []
cutHalf xs
 | ((mod (length xs) 2) == 1) = take (div (length xs + 1) 2) xs
 | otherwise = take (div (length xs) 2) xs

findSmall :: [Int] -> Int
findSmall [] = -999
findSmall [x] = x
findSmall (y : x : xs)
 | y < x = y
 | otherwise = findSmall (x : xs)


isAcceptable :: ([Int],[Int]) -> Bool
isAcceptable ([], []) = False
-- isAcceptable (ls, rs) = (isPalindrome ps) && (ps !! 0 == 4) && ((ndps !! (length ndps - 1) == 3) || (ndps !! (length ndps - 2) == 3)) 
isAcceptable (ls, rs) = (isPalindrome ps) && (ps !! 0 == 4) && (findSmall (reverse ndps) == 3)
 where
  p = (number ls) * (number rs)
  ps = digits p
  ndps = cutHalf ps

acceptables :: [([Int],[Int])]
acceptables = filter isAcceptable possibles

```

#### Version3(logival wrong)
[([5,2,1,3,4,7,6],[8,9]),([7,1,6,3],[5,9,2,4,8]),([5,9,2,4,8],[7,1,6,3]),([8,9],[5,2,1,3,4,7,6])]

```haskell
smallThree :: [Int] -> Bool
smallThree [] = False
smallThree (x : xs)
 | (x == 3) = True
 | (x < 3) = False
 | otherwise = smallThree xs

isAcceptable :: ([Int],[Int]) -> Bool
isAcceptable ([], []) = False
-- isAcceptable (ls, rs) = (isPalindrome ps) && (ps !! 0 == 4) && ((ndps !! (length ndps - 1) == 3) || (ndps !! (length ndps - 2) == 3)) 
isAcceptable (ls, rs) = (isPalindrome ps) && (ps !! 0 == 4) && smallThree (reverse ndps)
 where
  p = (number ls) * (number rs)
  ps = digits p
  ndps = cutHalf ps
```


