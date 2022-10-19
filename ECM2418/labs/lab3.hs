-- myApplist :: Foldable t => t a -> [a] -> [a]
myApplist :: [a] -> [a] -> [a]
myApplist xs ys = foldr (:) ys xs

myConcatlist xss = foldr (++) [] xss

triangles1 :: Fractional a => [a] -> [a]
triangles1 (x : xs) = ( x * (1 + x) / 2) : triangles1 xs

triangles = [ x * (1 + x) / 2 | x <- [1..]]


