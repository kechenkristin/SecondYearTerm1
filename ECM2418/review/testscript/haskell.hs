-- ch2
double x = x + x
quadruple x = double (double x)

factorial n = product [1..n]
average ns = sum ns `div` length ns

-- ch3
add1 :: (Int, Int) -> Int
add1 (x, y) = x + y

add2 :: Int -> (Int -> Int)
add2 x y = x + y

-- ch4
pyths :: Int -> [(Int, Int, Int)]
pyths z = [(x, y, z) | x, y, z <- x^2 + y^2 = z^2]


perfects :: Int -> [Int]
perfects n = 
