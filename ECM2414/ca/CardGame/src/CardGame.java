import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * the entrance for the card game
 */
public class CardGame {


    /**
     * the Player for the game
     * thread-safe
     * each player has unique id
     * each player will hold a hand of 4 cards
     */
    class Player implements Runnable {

        // fields
        /**
         * the unique id of each player
         */
        private Integer id;
        private boolean win;

        private PlayerFileHandler playerFileHandler;


        /**
         * Each player will hold a hand of 4 cards
         */
        ConcurrentLinkedDeque<Card> cards;

        // constructor

        public Player(Integer id, ConcurrentLinkedDeque<Card> cards) {
            this.id = id;
            this.cards = cards;
            win = false;
            playerFileHandler = new PlayerFileHandler(id);
        }


        public Player(Integer id) {
            this.id = id;
            this.cards = new ConcurrentLinkedDeque<>();
            win = false;
            playerFileHandler = new PlayerFileHandler(id);
        }

        // getters and setters
        public void setId(Integer id) {
            this.id = id;
        }


        public Integer getId() {
            return id;
        }

        public ConcurrentLinkedDeque<Card> getCards() {
            return cards;
        }

        /**
         * Convert card lists into integer vals list
         */
        private List<Integer> convertCardstoInteger() {
            List<Integer> vals = new ArrayList<>();
            for (Card c : cards) {
                vals.add(c.getVal());
            }
            return vals;
        }

        /**
         * check all the values of carde quals
         *
         * @return true if all values are equal, vals has the same elements.
         */
        private boolean checkCardValEqual(List<Integer> vals) {
            for (Integer s : vals) {
                if (!s.equals(vals.get(0)))
                    return false;
            }
            return true;
        }


        /**
         * check the player wins or not
         */
        public boolean checkWin() {
            return checkCardValEqual(convertCardstoInteger());
        }


        /***
         * helper method for drawCard
         * @param deck: which deck the player draws card
         * @return the card the player draws
         */
        private Card drawCardFromDeck(CardDeck deck) throws NoCardsException {
            if (deck.getCards().size() == 0) throw new NoCardsException("The deck is empty, could not draw cards!");
            if (deck.getCards().isEmpty()) {
                // todo : handdle this case
                System.out.println("The decks should not be empty");
                return null;
            }
            // notice: the last element of the deque is the top of the deck.
            // notice: the card should be removed from the deck.
            return deck.getCards().pollLast();
        }

        /**
         * generate draw string when the player draws card.
         *
         * @param deckId  which deck the player draws cards from
         * @param cardVal the card value of the player drawn card.
         */
        private void generateDrawString(int deckId, int cardVal) {
            playerFileHandler.write("player " + id + " draws a " + cardVal + " from deck " + deckId);
        }

        /**
         * A player draw a card form the top of the deck to their right.
         */
        // todo: where to sychronised
        // todo: test whether the decks List CardGame has modified
        public void drawCard() throws NoCardsException, EmptyDecksException {
            if (!checkWin()) {
                if (decks.isEmpty())
                    throw new EmptyDecksException("The Decks should not be empty, there is no decks for the card game!");
                // which deck the player should draw, p1 -> 1, p2 -> 2 etc
                Card drawCard = drawCardFromDeck(decks.get(id - 1));
                // todo : the order of player's hand cards
                cards.addLast(drawCard);
                assert drawCard != null;
                generateDrawString(id, drawCard.getVal());
            }
        }

        /**
         * helper method for discardCard, a player discard to the bottom of the deck
         *
         * @param discardCard: the card the player discards
         * @param deck:        the deck the player discards card
         */
        private void discardCardFromDeck(Card discardCard, CardDeck deck) {
            deck.cards.addFirst(discardCard);
        }

        /**
         * calculate the id of the deck player discards card
         *
         * @return deck Id
         */
        private int discardDeckId(int numberOfPlayers) {
            if (id == numberOfPlayers) return 1;
            return id + 1;
        }

        /**
         * find non preferred card for player to discard.
         *
         * @return the card to discard
         */
        // todo : update to be private
        Card findNonPreferCard() {
            if (!win) {
                for (Card card : cards) {
                    if (!card.getVal().equals(id)) {
                        cards.remove(card);
                        return card;
                    }
                }
            }
            return null;
        }

        /**
         * generate discard string when the player draws card.
         *
         * @param deckId  which deck the player to discard card
         * @param cardVal the card value of the player discarded card.
         */
        private void generateDiscardString(int deckId, int cardVal) {
            playerFileHandler.write("player " + id + " discards a " + cardVal + " to deck " + deckId);
        }

        /**
         * A player discard a card form the top of the deck to their right.
         */
        // todo: where to sychronised
        public void discardCard() throws NoCardsException, WrongNumberCardsInHandException {
            if (!checkWin()) {
                if (cards.size() == 0) throw new NoCardsException("The player has no cards in hand to discard!");
                if (cards.size() != 5)
                    throw new WrongNumberCardsInHandException("The player has wrong number of cards in hand!");
                int discardDeckId = discardDeckId(numOfPlayers);
                Card cardToDiscard = findNonPreferCard();
                discardCardFromDeck(cardToDiscard, decks.get(discardDeckId - 1));
                generateDrawString(discardDeckId, cardToDiscard.getVal());
            }
        }

        /**
         * get a String of the cards the player holds
         */
        private String getHandCardsString() {
            StringBuilder sb = new StringBuilder();
            for (Card c : cards) {
                sb.append(c.getVal());
                sb.append(" ");
            }
            return sb.toString();
        }

        /**
         * just generate initial hand message fo the output file
         * eg. player1 initial hand 1 1 2 3
         */
        public void initHand() {

            playerFileHandler.write("player " + id + " initial hand " + getHandCardsString());
        }

        /**
         * just generate current hand message fo the output file
         * eg. player1 initial hand 1 1 2 4
         */
        public void currentHand() {
            playerFileHandler.write("player " + id + " current hand " + getHandCardsString());
        }

        // todo how to find the winner

        /**
         * helper method for lastLines
         *
         * @param winnerId
         */
        private void generateWinString(int winnerId) {
            if (win) {
                playerFileHandler.write("player " + id + " wins");
            } else {
                playerFileHandler.write("player " + winnerId + " has informed player " + id + " that player " + winnerId + " has won");
            }
        }

        /**
         * helper method for lastLines
         */
        private void generateEndString() {
            playerFileHandler.write("player " + id + " exits");
            playerFileHandler.write("player " + id + " final hand: " + getHandCardsString());
        }

        private void lastLines(int winnerId) {
            generateWinString(winnerId);
            generateEndString();
        }

        public void notifyOthers() {
            synchronized (lock) {
                if (win) {
                    notifyAll();
                }
            }
        }


        @Override
        public void run() {
            synchronized (lock) {
                while (!win) {
                    try {
                        drawCard();
                    } catch (NoCardsException | EmptyDecksException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        discardCard();
                    } catch (NoCardsException | WrongNumberCardsInHandException e) {
                        throw new RuntimeException(e);
                    }
                    currentHand();

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }


    // fields
    /**
     * the number of players for the cardgame(n), get from user's input in command line
     */
    private int numOfPlayers;


    /**
     * The pack for the card game, which is a source of all cards for the card game,
     * get from .txt file(need to know the location)
     */
    private List<Card> pack;

    /**
     * the location of the source file for pack
     */
    private String packFileLocation;

    /**
     * All the players in the CardGame
     */
    private List<Player> players;

    /**
     * All the decks in the CardGame;
     */
    private List<CardDeck> decks;

    /**
     * a lock for all players of the game
     */
    final Object lock = new Object();

    // constructors
    // default
    public CardGame() {
        pack = new ArrayList<>();
        players = new ArrayList<>();
        decks = new ArrayList<>();
    }


    // methods

    /**
     * Request via the command line the number of players in the game
     */
    public void getPlayerNum() {
        System.out.println("Please enter the number of players:");
        scanNum();
    }


    /**
     * helper methods for getPLayNumber, scan user's input for command line
     */
    private void scanNum() {
        Scanner scanner = new Scanner(System.in);
        this.numOfPlayers = scanner.nextInt();
    }

    /**
     * get the pack for the card game.
     */
    public void getPack() {
        scanFileLocation();
        readPackFile(packFileLocation);
    }

    /**
     * scan the location of pack file form input in command line
     */
    private void scanFileLocation() {
        System.out.println("Please enter location of pack to load");
        Scanner scanner = new Scanner(System.in);
        this.packFileLocation = scanner.next();
    }

    /**
     * Read the card value form the target file.
     * check the validity of the pack file
     * 1. all the numbers are > 0
     * 2. 8n number
     * fielLocation: The location of the file
     */

    private void readPackFile(String fileLocation) {
        BufferedReader reader;
        int count = 0;
        try {
            reader = new BufferedReader(new FileReader(fileLocation));
            String line = reader.readLine();
            while (line != null) {
                count++;
                int number = Integer.parseInt(line);

                if (number < 0) {
                    informUser();
                    return;
                }

                Card card = new Card(number);
                pack.add(card);
                line = reader.readLine();
            }

            if (count != numOfPlayers * 8) {
                informUser();
            }
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * If the pack is invalid, inform the user and request a valid pack file
     */
    private void informUser() {
        System.out.println("The pack is invalid. Please provide a valid pack location.");
        pack = new ArrayList<>();
        getPack();
    }


    /**
     * Initialize players and decks for the CardGame
     */
    public void initPlayersAndDecks() {
        for (int i = 1; i <= numOfPlayers; i++) {
            players.add(new Player(i));
            decks.add(new CardDeck(i));
        }
    }

    /**
     * deal cards for players in a rounnd robin fashion
     */
    private void dealCardForPlayer() {
        // copy the first part of the list to deal to the player
        for (int i = 0; i < numOfPlayers * 4; i++) {
            // todo : check it later
            synchronized (pack) {
                players.get((i % numOfPlayers) + 1).cards.add(pack.get(i));
            }
        }
    }

    /**
     * generate init String for each player
     */
    public void gernerateInitHand() {
        for (Player p : players) {
            p.initHand();
        }
    }

    /**
     * deal cards for players in a rounnd robin fashion
     */
    private void dealCardForDeck() {
        for (int i = numOfPlayers * 4; i < numOfPlayers * 8; i++) {
            // todo : check it later
            synchronized (pack) {
                decks.get((i % numOfPlayers) + 1).cards.add(pack.get(i));
            }
        }
    }

    /**
     * check the exit logical of the game, if the win flag of one of the players is true, then the game end.
     */
    // todo: implement the win player should notify other player, and exit.
    public void checkGameEnd() {
        for (Player player : players) {
            if (player.checkWin()) {
                System.out.println("Player" + player.getId() + "wins");
            }
        }
    }


    // todo : print out the winner methods


    // main method
    public static void main(String[] args) {
        CardGame cg = new CardGame();
        // scan number of players
        cg.getPlayerNum();
        cg.getPack();

        // todo : implement wait notify.


    }

}
