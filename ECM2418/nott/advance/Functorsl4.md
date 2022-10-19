### pure & impure
- pure = programs are mathematical functions

- impure = programs have side effects

- combine -> Monads

### Abstracting Programming Patterns
- eg
```haskell
inc :: [Int] -> [Int] 
inc [] = []
inc (n : ns) = n + 1 : inc ns

sqr :: [Int] -> [Int]
sqr [] = []
sqr (n : ns) = n^2 : sqr ns
```
note: (n + 1) and n^2 are common pattern

- with map
```haskell
map :: (a -> b) -> [a] -> [b]
map f [] = []
map f (x : xs) = f x : map f xs

inc = map (+1)
sqr = map (^2)
```

- manards are example of abstracting common pattern

### Gereralising Futher
```haskell
class Functor f where
 fmap :: (a -> b) -> fa -> fb
```
f : parametralise type

### Examples of Functors

1. The list functor
```haskell
instance Functor [] where
__ fmap :: (a -> b) -> [a] -> [b]
fmap = map
```
[] : parametralise type of list

2. The Maybe Functor
- recap: the def of Maybe
```haskell
data Maybe a = Nothing | Just a
```

- make Maybe an instance of Functor
```haskell
instance Functor Maybe where
 __ fmap :: (a -> b) -> Maybe a -> Maybe b
 fmap g Nothing = Nothing
 fmap g (Just x) = Just (g x)
```
- ghci demo examples

> fmap (+1) Nothing 
Noting

> fmap (*2) (Just 3)
Just 6

> fmap not (Just False)
Just True

3. Binary Tree


