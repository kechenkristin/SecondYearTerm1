## Monads2
### Recap
1. safediv
```haskell
safediv :: Int -> Int -> Maybe Int
safediv _ 0 = Nothing
safediv n m = Just (div n m)
```

2. def of bind operation for Maybe Type
```haskell
(>>=) :: Maybe a -> (a -> Maybe b) -> Maybe b

Nothing >>= f = Nothing
(Just x) >>= f = f x
```

3. using bind operation to simplify
```haskell
eval :: Expr -> Maybe Int
eval (Val n) = Just n
eval (Div x y) = eval x >>= (\n -> eval y >>= (\m -> safediv n m))
```

4. using do notation to simply
do notation is a syntax sugar for repeated use of bind operator
```haskell
eval :: Expr -> Maybe Int
eval (Val n) = Just n
eval (Div x y) = do n <- eval x
                    m <- eval y
                    safediv n m
```

### Def of Monads
1. In haskell, the class of applicative functors that support a bind operator called Monads.
```haskell
class Applicative m => Monad m where
 (>>=) :: m a -> (a -> m b) -> m b
 return :: a -> m a

 return = pure
```

### Examples
1. Maybe
```haskell
instance Monad Maybe where
 _ _ (>>=) :: Maybe a -> (a -> Maybe b) -> Maybe b
 Nothing >>= f = Nothing
 Just x >>= f = f x
```

2. List

(1). def

```haskell
instance Monad [] where
 _ _ (>>=) :: [a] -> (a -> [b]) -> [b]
 xs >>= f = concat(map f xs)
          = [y | x <- xs, y <- f x]
```
xs : [a]

f : a -> [b]

map f xs : [[b]]

(2). eg

```
> pairs [1, 2] [3, 4]
[(1, 3), (1, 4), (2, 3), (2, 4)]
```

```haskell
pairs :: [a] -> [b] -> [(a, b)]
pairs xs ys = do x <- xs
                 y <- ys
                 return (x, y)

-- using list comprehension
pairs xs ys = [(x, y) | x <- xs, y <- ys]
```
ps. do notation is not specific to list, but any monad, the list comprehension only works for list.

3. State (Important)

(1). What is State?
```haskell
type State = ...
type ST a = State -> (a, State)
```
ST : State Transformer

```
        ____
       |    |----> v
----> S|    |
       |____|----> S`    
```
 

eg
```haskell
Char -> State -> (Int, State)
```

```
        ____
----> c|    |----> i
       |    |
----> S|____|----> S`    
```
 
(2). def

```haskell
newtype ST a = S (State -> (a, State))

app :: ST a -> State -> (a, State)
app (S st) s = st s
```

(3). make ST in to an instance of Monad type


```haskell
instance Monad ST where
 _ _ return :: a -> ST a
 return x = S (\s -> (?, ?))
```

x : a

s : State

? : a

? : State

```haskell
instance Monad ST where
 _ _ return :: a -> ST a
 return x = S (\s -> (x, s))
```


```
        ______
----> x|      |----> x
       |return|
----> S|______|----> S    
```

define bind operator
```haskell
_ _(>>=) :: ST a -> (a -> ST b) -> ST b
st >>= f = S(\s -> let(x, s`) = app st s in app(f x) s`)
```

```
        ______           _____
       |      |----> x  |     |-----> x`
       |  st  |         |  f  |
----> S|______|----> S` |_____|-----> S``  
```




st : ST a

f : a -> ST b
