-- Evaluating Expressions
-- Operations
data Op = Add | Sub | Mul | Div

-- Apply an operator
apply :: Op -> Int -> Int -> Int
apply Add x y = x + y
apply Sub x y = x - y
apply Mul x y = x * y
apply Div x y = div x y

-- Validate
valid :: Op -> Int -> Int -> Bool
valid Add _ _ = True
valid Sub x y = x > y
valid Mul _ _ = True
valid Div x y = mod x y == 0

-- Expressions
data Expr = Val Int | App Op Expr Expr

-- Evaluate, return the overall value of an expression, provided that it is a positive natural number
eval :: Expr -> [Int]
eval (Val n) = [n | n > 0]
eval (App o l r) = [apply o x y | x <- eval l, y <- eval r, valid o x y]


