## Monads2
### Recap
1. safediv
```haskell
safediv :: Int -> Int -> Maybe Int
safediv _ 0 = Nothing
safediv n m = Just (div n m)

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
