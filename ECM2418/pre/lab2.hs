applist :: [a] -> [a] -> [a]
applist [] ys = ys
applist (x: xs) ys = x : applist xs ys

applist1 :: [a] -> [a] -> [a]
applist1 xs ys = foldr (:) ys xs

revlist :: [a] -> [a]
revlist [] = []
revlist (x : xs) = revlist xs ++ [x]

revlist1 :: [a] -> [a]
revlist1 (x : xs) = foldr (\x xs -> xs ++ [x]) [] xs

pam :: [a -> b] -> a -> [b]
pam [] xs = []
pam (f : fs) xs = f xs : pam fs xs

concatlist :: [[a]] -> [a]
concatlist xss = [x | xs <- xss, x <- xs]

concatlist1 :: [[a]] -> [a]
concatlist1 [] = []
concatlist1 (xs : xss) = applist xs (concatlist xss)

concatlist2 :: [[a]] -> [a]
concatlist2 xss = foldr (++) [] xss
