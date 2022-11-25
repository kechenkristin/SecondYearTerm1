## About this project
A multithread card game.

## File Arch
```
.
├── CardGame.iml
├── cards.jar
├── deck1_output.txt
├── deck2_output.txt
├── deck3_output.txt
├── deck4_output.txt
├── out
│   ├── production
│   │   └── CardGame
│   │       ├── Card.class
│   │       ├── CardDeck.class
│   │       ├── CardGame$Player.class
│   │       ├── CardGame.class
│   │       ├── DeckFileHandler.class
│   │       ├── EmptyDecksException.class
│   │       ├── META-INF
│   │       │   └── MANIFEST.MF
│   │       ├── NoCardsException.class
│   │       ├── PlayerFileHandler.class
│   │       └── WrongNumberCardsInHandException.class
│   └── test
│       └── test
│           ├── CardGameTest.class
│           ├── deck1_output.txt
│           ├── deck2_output.txt
│           ├── deck3_output.txt
│           ├── deck4_output.txt
│           ├── player1_output.txt
│           ├── player4_output.txt
│           ├── PlayerTest.class
│           ├── test.iml
│           ├── TestSuite.class
│           └── test.txt
├── player1_output.txt
├── player2_output.txt
├── player3_output.txt
├── player4_output.txt
├── README.md
├── src
│   ├── CardDeck.java
│   ├── CardGame.java
│   ├── Card.java
│   ├── DeckFileHandler.java
│   ├── EmptyDecksException.java
│   ├── META-INF
│   │   └── MANIFEST.MF
│   ├── NoCardsException.java
│   ├── PlayerFileHandler.java
│   └── WrongNumberCardsInHandException.java
├── test
│   ├── CardGameTest.java
│   ├── deck1_output.txt
│   ├── deck2_output.txt
│   ├── deck3_output.txt
│   ├── deck4_output.txt
│   ├── player1_output.txt
│   ├── player4_output.txt
│   ├── PlayerTest.java
│   ├── test.iml
│   ├── TestSuite.java
│   └── test.txt
├── test.txt
└── win.txt

9 directories, 54 files
```

## Run the TestSuite
- provide a pack file(with the format of .txt) in test folder
- compile and run

## Run the main method 
- provide a pack file(.txt) in the CardGame folder
- initialize a CardGame instance
- call the instance's startGame method

## Use the jar file
```
kristin@kristin-PC:~/study/exeter/year2/ECM2414/ca/CardGame$ java -cp .:cards.jar src/CardGame.java
Please enter the number of players:
4
Please enter location of pack to load
test.txt
game start.
Player 4 wins the game
```

## Contact
- Author Kechen Heegon
- git hub

https://github.com/kechenkristin/ECM2414_CA


