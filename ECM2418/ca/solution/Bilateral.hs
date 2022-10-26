-- any imports go here
import Data.List

{-Begin Question 2.1-}
number :: [Int] -> Int
number [] = 0
number (x : xs) = x * 10 ^ ((length xs)) + number xs

{-End Question 2.1-}

{-Begin Question 2.2-}
splits :: [a] -> [([a],[a])]
splits xs = [splitAt i xs | i <- [1..(length xs -1)]]

possibles :: [([Int],[Int])]
possibles = concat[splits xs | xs <- permutations [1..9]]

{-End Question 2.2-}

{-Begin Question 2.3-}
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
findSmall (x : y : ys)
 | x < y = x
 | otherwise = findSmall (y : ys)

isAcceptable :: ([Int],[Int]) -> Bool
isAcceptable ([], []) = False
-- isAcceptable (ls, rs) = (isPalindrome ps) && (ps !! 0 == 4) && ((ndps !! (length ndps - 1) == 3) || (ndps !! (length ndps - 2) == 3)) 
-- isAcceptable (ls, rs) = (isPalindrome ps) && (ps !! 0 == 4) && smallThree (reverse ndps)
isAcceptable (ls, rs) = (isPalindrome ps) && (ps !! 0 == 4) && findSmall(reverse ndps) == 3
 where 
  p = (number ls) * (number rs)
  ps = digits p
  ndps = cutHalf ps

acceptables :: [([Int],[Int])]
acceptables = filter isAcceptable possibles

{-End Question 2.3-}

-- any main functions for testing goes here
