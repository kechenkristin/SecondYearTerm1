module Interpreter
(
    AExp(..),
    BExp(..),
    Com (..),
    aval,
    bval,
    eval
) where

import Data.Map
import Machine

--TODO Task 2.1
data AExp =
    N Val |
    V Vname |
    Plus AExp AExp
    deriving (Eq, Read, Show)

--TODO Task 2.2
aval :: AExp -> State -> Val
aval (N x) state = x
aval (V x) state = state ! x
aval (Plus a b) state = aval a state + aval b state

--TODO Task 2.1
data BExp =
    Bc Bool |
    Not BExp |
    And BExp BExp |
    Less AExp AExp
    deriving (Eq, Read, Show)

--TODO Task 2.3
bval :: BExp -> State -> Bool
bval (Bc b) state = b
bval (Not b) state = not (bval b state)
bval (And b1 b2) state = bval b1 state && bval b2 state
bval (Less a b) state = aval a state < aval b state

--TODO Task 2.1
data Com =
    Assign Vname AExp |
    Seq Com Com |
    If BExp Com Com |
    While BExp Com |
    SKIP
    deriving (Eq, Read, Show)

--TODO Task 2.4
eval :: Com -> State -> State
eval (Assign v x) state = insert v (aval x state) state
eval (Seq c1 c2) state = eval c2 (eval c1 state)
eval (If b c1 c2) state
  | bval b state = eval c1 state
  | otherwise = eval c2 state
eval (While b c) state
  | bval b state = eval (While b c) (eval c state)
  | otherwise = state
eval SKIP state = state
