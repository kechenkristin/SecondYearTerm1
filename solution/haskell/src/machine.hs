module Machine
(
        Vname,
        Val,
        State,
        Instr (..),
        Stack,
        Config,
        iexec,
        exec
) where

import Data.Map

--TODO Task 1.1
type Vname = String
--TODO Task 1.2
type Val = Int
--TODO Task 1.3
type State = Map Vname Val

--TODO Task 1.4
data Instr =
        LOADI Val |
        LOAD Vname |
        ADD |
        STORE Vname |
        JMP Int |
        JMPLESS Int |
        JMPGE Int
        deriving (Eq, Read, Show)

--TODO Task 1.5
type Stack = [Val]

--TODO Task 1.6
type Config = (Int, State, Stack)

--TODO Task 1.7
iexec :: Instr -> Config -> Config
iexec (LOADI x) (pc, state, stack) = (pc + 1, state, x:stack)
iexec (LOAD v)  (pc, state, stack) = (pc + 1, state, (state ! v):stack)
iexec ADD (pc, state, x:y:xs) = (pc + 1, state, (x+y):xs)
iexec (STORE v) (pc, state, x:xs) = (pc + 1, insert v x state, xs)
iexec (JMP i) (pc, state, stack) = (pc + i + 1, state, stack)
iexec (JMPLESS i) (pc, state, x:y:xs)
  | y < x = (pc + i + 1, state, xs)
  | otherwise = (pc + 1, state, xs)
iexec (JMPGE i) (pc, state, x:y:xs)
  | x <= y = (pc + i + 1, state, xs)
  | otherwise = (pc + 1, state, xs)

--TODO Task 1.8
exec :: [Instr] -> Config -> Config
exec instr (pc, state, stack)
  | pc == length instr = config
  | otherwise = exec instr (iexec (instr!!pc) config)
    where config = (pc, state, stack)
