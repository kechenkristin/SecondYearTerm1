## Monads1

### Recap
1. Functor
```haskell
class Functor f where
 fmap :: (a -> b) -> f a -> f b
```

```
> fmap (+1) (Just 1) 
Just 2
> fmap (+1) Nothing
```

2. Applicative Functor
```haskell
class Functor f => Applicative f where
 pure :: a -> f a
 (<*>) :: f (a -> b) -> f a -> f b
```

```
> pure (+) <*> Just 1 <*> Just 2
Just 3
> pure (+) <*> Nothing <*> Just 2
Nothing
```

### Example: s simple evaluator
1. Strawman Idea
```haskell
data Expr = Val Int | Div Expr Expr
eval :: Expr -> Int
eval (Val n) = n
eval (Div x y) = div (eval x) (eval y)
```
problem: if eval y equals to 0, the program will crash.

2. Apporach
(1). A safe version of division function
```haskell
safediv :: Int -> Int -> Maybe Int
safediv _ 0 = Nothing
safediv n m = Just (div n m)
```

(2). 
```haskell
eval :: Expr -> Maybe Int
eval (Val n) = Just n
eval (Div x y) = case eval x of 
                  Nothing -> Nothing
                  Just n -> case eval y of 
                   Nothing -> Nothing
                   Just m -> safediv n m
```
Problem: too complex for a small program.

(3).
```haskell
eval :: Expr -> Maybe Int
eval (Val n) = pure n
eval (Div x y) = pure safediv <*> eval x <*> eval y
```
type error

eval x : Maybe Int

eval y : Maybe Int

pure safediv : need Int -> Int -> Int

but we have Int -> Int -> Maybe Int

### Binding Operator : (>>=)
1. Absorb a common pattern
```haskell
mx >>= f = case mx of 
            Nothing -> Nothing
            Just x -> f x
```

2. type (>>=)
```haskell
(>>=) :: Maybe a -> (a -> Maybe b) -> Maybe b
```

3. Simplify the def of eval
```haskell
eval :: Expr -> Maybe Int
eval (Val n) = Just n
eval (Div x y) = eval x >>= (\n -> eval y >>= (\m -> safediv n m))
```

4. General Pattern
```haskell
m1 >>= \x1 -> 
m2 >>= \m2 ->
...
mn >>= \xn ->
f x1 x2 ... xn
```

### Do Notation
1. syntex sugar
```haskell
do x1 <- m1
   x2 <- m2
   xn <- mn
   f x1 x2 ... xn
```

2. wrap eval
```haskell
eval :: expr -> Maybe Int
eval (Val n) = Just n
eval (Div x y) = do n <- eval x
                    m <- eval y
                    safediv n m
```

3. benefit

(1). Simple, and if both of eval x, eval y success, we call safediv, we don't need to worry the failure, because it is handled by the bindingoperationand do notation.

(2). Procedural style like C, but a pure functional programming.
