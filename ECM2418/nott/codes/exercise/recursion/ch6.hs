fac :: Int -> Int
fac 0 = 1
fac n = n * fac (n - 1)

product :: Num a => [a] -> a
product [] = 1
product (x : xs) = x * product xs

length :: [a] -> Int
length [] = 0
length (_ : ns) = 1 + length ns

reverse :: [a] -> [a]
reverse [] = []
reverse (x : xs) = reverse xs ++ [x]

zip :: [a] -> [b] -> [(a, b)]
zip _ [] = []
zip [] _ = []
zip (x : xs) (y : ys) = (x, y) : zip xs ys

drop :: Int -> [a] -> [b]
drop 0 xs = xs
drop n [] = []
drop n (_ : xs) = drop (n - 1) xs

