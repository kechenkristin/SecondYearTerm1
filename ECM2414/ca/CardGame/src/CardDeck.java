import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * The CardDeck for the card game, a deck is a set of card where player can draw or discard card.
 * <p>
 * each deck has unique id
 * each deck has number of cards
 */

public class CardDeck {

    // fields
    /**
     * a unique id for each deck
     */
    private Integer deckId;

    /**
     * deck file handler
     */
    private DeckFileHandler deckFileHandler;


    /**
     * the cards for each deck
     */
    // todo : makes it private
    public volatile ConcurrentLinkedDeque<Card> cards;


    // constructors
    public CardDeck(Integer deckId) {
        this.deckId = deckId;
        this.cards = new ConcurrentLinkedDeque<>();
        this.deckFileHandler = new DeckFileHandler(deckId);
    }

    // getters and setters


    public Integer getDeckId() {
        return deckId;
    }

    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }

    public ConcurrentLinkedDeque<Card> getCards() {
        return cards;
    }

    public void setCards(ConcurrentLinkedDeque<Card> cards) {
        this.cards = cards;
    }

    /**
     * get a String of the cards the deck holds
     *
     * @return
     */
    private String getDeckCardsString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            sb.append(c.getVal());
            sb.append(" ");
        }
        return sb.toString();
    }

    public void generateDeckString() {
        deckFileHandler.write("deck" + deckId + " contents: " + getDeckCardsString());
    }
}
