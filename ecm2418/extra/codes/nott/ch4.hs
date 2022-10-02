myTail1 :: [a] -> [a]

myTail1 xs = if null xs then [] else tail xs

myTail2 :: [a] -> [a]

myTail2 xs | null xs = []
           | otherwise =  tail xs

safeTail [] = []
safeTail (_:xs) = xs

