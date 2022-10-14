mapFilter1 f p xs = [f x | x <- xs, p x]
mapFIlter2 f p xs = map f (filter p xs)
