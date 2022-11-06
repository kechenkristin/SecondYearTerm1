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


        private final PlayerFileHandler playerFileHandler;


        /**
         * Each player will hold a hand of 4 cards
         */
        // todo update to be private
        volatile ConcurrentLinkedDeque<Card> cards;

        // constructor

        /**
         * Create a player with Id
         */
        public Player(Integer id) {
            this.id = id;
            win = false;
            cards = new ConcurrentLinkedDeque<>();
            playerFileHandler = new PlayerFileHandler(id);
        }


        // getters and setters

        public PlayerFileHandler getPlayerFileHandler() {
            return playerFileHandler;
        }

        public Integer getId() {
            return id;
        }

        public ConcurrentLinkedDeque<Card> getCards() {
            return cards;
        }

        public void setCards(ConcurrentLinkedDeque<Card> cards) {
            this.cards = cards;
        }

        /**
         * Convert card lists into integer vals list
         */
        private List<Integer> convertCardstoInteger() {
            List<Integer> vars = new ArrayList<>();
            for (Card c : cards) {
                vars.add(c.getVal());
            }
            return vars;
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
        public synchronized boolean checkWin() {
            synchronized (playLock) {
                return checkCardValEqual(convertCardstoInteger());
            }
        }


        /***
         * helper method for drawCard
         * @param deck: which deck the player draws card
         * @return the card the player draws
         */
        private Card drawCardFromDeck(CardDeck deck) throws NoCardsException {
            if (deck.getCards().size() == 0) throw new NoCardsException("The deck is empty, could not draw cards!");
            if (deck.getCards().isEmpty()) {
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
        public synchronized void drawCard() throws NoCardsException, EmptyDecksException {
            synchronized (playLock) {
                if (decks.isEmpty()) {
                    throw new EmptyDecksException("The Decks should not be empty, there is no decks for the card game!");
                }
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
            for (Card card : cards) {
                if (!card.getVal().equals(id)) {
                    cards.remove(card);
                    return card;
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
        public synchronized void discardCard() throws NoCardsException, WrongNumberCardsInHandException {
            synchronized (playLock) {
                if (cards.size() == 0) throw new NoCardsException("The player has no cards in hand to discard!");
                if (cards.size() != 5)
                    throw new WrongNumberCardsInHandException("The player has wrong number of cards in hand!");
                int discardDeckId = discardDeckId(numOfPlayers);
                Card cardToDiscard = findNonPreferCard();

                // in case never happen in real world, but still handle it.
                if (cardToDiscard == null) {
                    win = true;
                    return;
                }
                discardCardFromDeck(cardToDiscard, decks.get(discardDeckId - 1));
                generateDiscardString(discardDeckId, cardToDiscard.getVal());
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

        @Override
        public void run() {
            while (!someWin) {
                if (checkWin()) {
                    someWin = true;
                    deckOutput();
                    System.out.println("Player " + id + " wins the game");
                    generateFinalString(id);
                } else {
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
                        Thread.sleep(20);
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
    private volatile List<Player> players;

    /**
     * All the decks in the CardGame;
     */
    private volatile List<CardDeck> decks;

    /**
     * Game end flag, if someone has won the game
     */
    private volatile boolean someWin = false;

    /**
     * a lock for all players of the game
     */
    static final Object playLock = new Object();

    // constructors
    // default
    public CardGame() {
        pack = new ArrayList<>();
        players = new ArrayList<>();
        decks = new ArrayList<>();
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void setPack(List<Card> pack) {
        this.pack = pack;
    }


    public void setDecks(List<CardDeck> decks) {
        this.decks = decks;
    }

    // methods


    /**
     * helper methods for getPLayNumber, scan user's input for command line
     */
    private void scanNum() {
        Scanner scanner = new Scanner(System.in);
        this.numOfPlayers = scanner.nextInt();
    }

    /**
     * Request via the command line the number of players in the game
     */
    public void getPlayerNum() {
        System.out.println("Please enter the number of players:");
        scanNum();
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
     * get the pack for the card game.
     */
    public void getPack() {
        scanFileLocation();
        readPackFile(packFileLocation);
    }


    /**
     * Initialize players and decks for the CardGame
     */
    void initPlayersAndDecks() {
        for (int i = 1; i <= numOfPlayers; i++) {
            players.add(new Player(i));
            decks.add(new CardDeck(i));
        }
    }

    /**
     * deal cards for players in a rounnd robin fashion
     */
    void dealCardForPlayer() {
        // copy the first part of the list to deal to the player
        for (int i = 0; i < numOfPlayers * 4; i++) {
            // todo : check it later
            players.get((i % numOfPlayers)).cards.add(pack.get(i));
        }
    }

    /**
     * generate init String for each player
     */
    void generateInitHand() {
        for (Player p : players) {
            p.initHand();
        }
    }

    /**
     * deal cards for players in a rounnd robin fashion
     */
    void dealCardForDeck() {
        for (int i = numOfPlayers * 4; i < numOfPlayers * 8; i++) {
            // todo : check it later
            decks.get((i % numOfPlayers)).cards.add(pack.get(i));
        }
    }

    /**
     * write out final string for deck.
     */
    public void deckOutput() {
        for (CardDeck cardDeck : decks) {
            cardDeck.generateDeckString();
        }
    }

    /**
     * write out final strings for players
     *
     * @param winnerId the id of the winner player
     */
    public void generateFinalString(int winnerId) {
        for (Player p : players) {
            if (p.getId().equals(winnerId)) {
                p.getPlayerFileHandler().write("player " + winnerId + " wins");
            } else {
                p.getPlayerFileHandler().write("player " + winnerId + " has informed player " + p.getId() + " that player " + winnerId + " has won");
            }
            p.getPlayerFileHandler().write("player " + p.getId() + " exits");
            p.getPlayerFileHandler().write("player " + p.getId() + " final hand: " + p.getHandCardsString());
        }
    }


    /**
     * Start of the game.
     * Encapsulate all the game logic of starting game inside one method.
     */
    public void initGame() {
        getPlayerNum();
        getPack();
        initPlayersAndDecks();
        dealCardForPlayer();
        generateInitHand();
        dealCardForDeck();
    }

    public void startGame() {
        initGame();
        System.out.println("game start.");
        for (int i = 0; i < numOfPlayers; i++) {
            (new Thread(players.get(i))).start();
        }
    }


    // main method
    public static void main(String[] args) {
        CardGame cg = new CardGame();
        cg.startGame();
    }

}
