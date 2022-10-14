module Compiler
(
    acomp,
    bcomp,
    ccomp
) where

import Data.Map
import Machine
import Interpreter

--TODO Task 3.1
acomp :: AExp -> [Instr]
acomp (N x) = [LOADI x]
acomp (V x) = [LOAD x]
acomp (Plus a b) = acomp a ++ acomp b ++ [ADD]

--TODO Task 3.2
bcomp :: BExp -> Bool -> Int -> [Instr]
bcomp (Bc b1) b2 x = [JMP x | b1 == b2]
bcomp (Not b1) b2 x = bcomp b1 (not b2) x
bcomp (And b1 b2) b3 x = a ++ b
  where b = bcomp b2 b3 x
        c = if b3 then length b else length b + x
        a = bcomp b1 False c
bcomp (Less a1 a2) b3 x = acomp a1 ++ acomp a2 ++ (if b3 then [JMPLESS x] else [JMPGE x])

--TODO Task 3.3
ccomp :: Com -> [Instr]
ccomp SKIP = []
ccomp (Assign v x) = acomp x ++ [STORE v]
ccomp (Seq c1 c2) = ccomp c1 ++ ccomp c2
ccomp (If b c1 c2) = z ++ x ++ [JMP (length y)] ++ y
  where x = ccomp c1
        y = ccomp c2
        z = bcomp b False (length x + 1)
ccomp (While b c) = y ++ x ++ [JMP (-(length y + length x + 1))]
  where x = ccomp c
        y = bcomp b False (length x + 1)  
