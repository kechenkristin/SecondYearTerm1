### Generalising fmap

```haskell
fmap0 :: a -> f a
fmap1 :: (a -> b) -> f a -> f b
fmap2 :: (a -> b -> c) -> f a -> f b -> fc
fmap3 :: (a -> b -> c -> d) -> f a -> f b -> f c -> f d
...
```

```
> fmap (+) (Just 1) (Just 2)
Just 3
```
How to define fmap function, which takes as many as arguments as we like

Declear a new class to handle each case
```haskell
class Functor2 f where 
 fmap2 :: (a -> b -> c) -> f a -> f b -> f c
```
Mannually define each case, duplicate

New solution
Build any mapping operation we need in terms of two basic functions.
```haskell
pure :: a -> f a
((*)) :: f (a -> b) -> f a -> f b
```
pure : Convert a value into a data strcture in a simple way.
((*)) : Gerneralising form of function application.

```haskell
pure g (*) x (*) y (*) z
```

applicative style

```haskell
((pure g (*) x) (*) y) (*) z
((g x) y) z
```

how it works in practice?
```haskell
fmap0 :: a -> f a
fmap0 = pure

fmap1 :: (a -> b) -> f a -> f b
fmap1 g x = pure g (*) x

fmap2 :: (a -> b -> c) -> f a -> f b -> f c
fmap2 g x y = pure g (*) x (*) y
-- fmap2 g x y = (pure g (*) x) (*) y
```


### Applicative Functors
### def
```hakell
class Functor f => Applicative f where
 pure :: a -> f a
 ((*)) :: f (a -> b) -> f a -> f b
```

### Examples
#### Maybe
1. def
```haskell
instance Applicative Maybe where 
 _ _ pure :: a -> Maybe a
 pure x = Just x
 _ _ ((*)) :: Maybe (a -> b) -> Maybe a -> Maybe b
 Nothing (*) mx = Nothing
 (Just g) (*) mx = fmap g mx
```

2. demo
```
> pure (+1) (*) (Just 1)
Just 2
> pure (+) (*) Just 1 (*) Just 2
Just 3
> pure (+) (*) Nothing (*) Just 2
Nothing
```

#### Lists
1. def
```haskell
instance Applicative where 
 _ _ pure :: a -> [a]
 pure x = [x]
 _ _ ((*)) :: [a -> b] -> [a] -> [b]
 gs (*) xs = [g x | g <- gs, x <- xs]
```

2. demo
```
> pure (+1) (*) [1, 2, 3]
[2, 3, 4]
> pure (+) [1] (*) [2]
[3]
> pure (*) (*) [1, 2] (*) [3, 4]
[3, 4, 6, 8]
```
