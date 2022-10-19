import System.IO

-- top down approach to implementimg hangman in haskell, starting as follows:
hangman :: IO ()
hangman = do putStrLn "Think of a word: "
             word <- sgetLine
             putStrLn "Try to guess it: "
             play word

-- reads a line of text from the keyboard, echoing each character as a dash
sgetLine :: IO String
sgetLine = do x <- getCh
              if x == '\n' then 
                 do putChar x
                    return []
              else 
                 do putChar '-'
                 xs <- sgetLine
                 return (x : xs)

