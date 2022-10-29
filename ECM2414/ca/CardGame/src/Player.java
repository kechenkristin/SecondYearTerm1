import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * the Player for the game
 * thread-safe
 * each player has unique id
 * each player will hold a hand of 4 cards
 */
public class Player implements Runnable {

    // fields
    /**
     * the unique id of each player
     */
    private Integer id;
    private boolean win;


    /**
     * Each player will hold a hand of 4 cards
     */
    ConcurrentLinkedDeque<Card> cards;

    // constructor

    /**
     * default constructor
     */
    public Player() {
    }

    public Player(Integer id, ConcurrentLinkedDeque<Card> cards) {
        this.id = id;
        this.cards = cards;
        win = false;
    }


    public Player(Integer id) {
        this.id = id;
    }

    // getters and setters
    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    /**
     * Convert card lists into integer vals list
     * @return
     */
    private List<Integer> convertCardstiInteger() {
        List<Integer> vals = new ArrayList<>();
        for (Card c : cards) {
            vals.add(c.getVal());
        }
        return vals;
    }

    /**
     * check all the values of carde quals
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
        return checkCardValEqual(convertCardstiInteger());
    }


    /***
     * helper method for drawCard
     * @param deck: which deck the player draws card
     * @return the card the player draws
     */
    private Card drawCardFromDeck(CardDeck deck) {
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
     * A player draw a card form the top of the deck to their right.
     *
     * @param decks: a list of decks of the current card game.
     */
    // todo: where to sychronised
    // todo: test whether the decks List CardGame has modified
    public void drawCard(List<CardDeck> decks) {
        if (decks.isEmpty()) {
            // todo : handdle this case
            System.out.println("The decks should not be empty");
            return;
        }
        // which deck the player should draw, p1 -> 1, p2 -> 2 etc
        Card drawCard = drawCardFromDeck(decks.get(id - 1));
        // todo : the order of player's hand cards
        cards.addLast(drawCard);
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
     * A player discard a card form the top of the deck to their right.
     *
     * @param decks:           a list of decks of the current card gameGame.
     * @param numberOfPlayers: the numberofPlayers of the card
     */
    // todo: where to sychronised
    public void discardCard(List<CardDeck> decks, int numberOfPlayers) {
        int discardDeckId = discardDeckId(numberOfPlayers);
        discardCardFromDeck(findNonPreferCard(), decks.get(discardDeckId));
    }


    @Override
    public void run() {

    }
}
