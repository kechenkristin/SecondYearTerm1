## Monads1

### Example: s simple evaluator
#### Strawman Idea
```haskell
data Expr = Val Int | Div Expr Expr
eval :: Expr -> Int
eval (Val n) = n
eval (Div x y) = div (eval x) (eval y)
```
problem: if eval y equals to 0, the program will crash.

#### Apporach
1. A safe version of division function
```haskell
safediv :: Int -> Int -> Maybe Int
safediv _ 0 = Nothing
safediv n m = Just (div n m)
```

2. 
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





