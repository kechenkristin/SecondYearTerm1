module Main where

import System.Environment
import Compiler

--TODO Task 3.4
main :: IO ()
main = do
  args <- getArgs
  print(ccomp (read (unwords args)))
