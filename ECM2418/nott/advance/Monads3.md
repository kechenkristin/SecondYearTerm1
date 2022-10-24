## Monad3
### Recap

1. def of monad
```haskell
class Applicative m => Monad m where
 (>>=) :: m a -> (a -> m b) -> m b
 return a -> m a
 return = pure
```

2. state monad
```haskell
type State = ...
newType ST a = S (State -> (a, State))

app :: ST a -> State -> (a, State)
app (S st) s = st s
```

```haskell
Char -> Int
        ____ 
----> c|    |----> i
       |____|    
```	       

```haskell
Char -> ST Int = Char -> State -> (Int, State)
          ______
-----> c |      | -----> i
         |      |
-----> S |______| -----> S`
```

```haskell
instance Monad ST where
 _ _ return :: a -> ST a
 return x = S (\s -> (x, s))

          ______
-----> x |      | -----> x
         |return|
-----> S |______| -----> S
```

```haskell
instance Monad where
 _ _ (>>=) :: ST a -> (a -> ST b) -> ST b
 st >>= f = S (\s -> let (x, s`) = app st s 
                                   in app (f x) s`)


         ______         _______
        |      |---->x |      |-----> x` 
        |  st  |       |  f   | 
----->s |______|---->s`|______|-----> s``
```

### Example: relabelling tree
1. def
```haskell
data Tree a = Leaf a | Node (Tree a) (Tree a)
```

2. eg
```haskell
t :: Tree Char
t = Node (Node (Leaf 'a') (Leaf 'b')) (Leaf 'c')
```

3. strawman idea
```haskell
Tree a -> Int -> (Tree Int, Int)

rlabel :: Tree a -> Int -> (Tree Int, Int)
rlabel (Leaf x) n = (Leaf n, n + 1) 
rlabel (Node l r) n = (Node l` r` n``)
                     where
                      (l`, n`) = rlabel l n
                      (r`, n``) = rlabel r n`
```

4. Redefine with Monad
```haskell
fresh :: ST Int 
fresh = S (\n -> (n, n + 1))

mlabel :: Tree a -> ST (Tree Int)
mlabel (Leaf x) = do n <- fresh
                     return (Leaf n)

mlabel (Node l r) = l` <- mlabel l
                    r` <- mlabel r
                    return (Node l` r`)
```

5. wrap
```haskell
label :: Tree a -> Tree Int
label t = fst (app (mlabel t) 0)
```
