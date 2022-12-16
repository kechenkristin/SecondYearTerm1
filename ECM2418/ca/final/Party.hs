-- any imports go here

{-Begin Question 1.1-}
digits :: Int -> [Int]
digits = map (read . (:[])) .show

{-End Question 1.1-}

{-Begin Question 1.2-}
splitIntoTwo :: Int -> [Int]
splitIntoTwo n = (div n 100) : (mod n 100) : []

myUnique :: [Int] -> Bool
myUnique [] = True
myUnique (x : xs)
 | elem x xs = False
 | otherwise = myUnique xs


isPar :: Int -> Bool
isPar n
 | (mod (xs !! 1) (xs !! 0) == 0) && (myUnique (digits n)) && (notElem 0 (digits n)) = True
 | otherwise = False
  where 
   xs = splitIntoTwo n

pars :: [Int]
pars = [x | x <- [1000..9999], isPar x]

{-End Question 1.2-}

{-Begin Question 1.3-}
isParty :: (Int, Int) -> Bool
isParty (f, s) = myUnique ns && ((mod f miss) == 0) && ((mod s miss) == 0)
 where
  ns = (digits f) ++ (digits s)
  miss = [x | x <- [1..9], notElem x ns] !! 0
  

partys :: [(Int, Int)]
partys = [(x, y) | x <- pars, y <- pars, isParty (x, y)]

{-End Question 1.3-}

-- any main functions for testing goes here
