import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * The CardDeck for the card game, a deck is a set of card where player can draw or discard card.
 *
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
     * the cards for each deck
     */
    // todo : makes it private
    public ConcurrentLinkedDeque<Card> cards;

    // constructors
    public CardDeck(Integer deckId, ConcurrentLinkedDeque<Card> cards) {
        this.deckId = deckId;
        this.cards = cards;
    }



    public CardDeck(Integer deckId) {
        this.deckId = deckId;
    }

    // getters and setters


    public Integer getDeckId() {
        return deckId;
    }

    public ConcurrentLinkedDeque<Card> getCards() {
        return cards;
    }


    public void setDeckId(Integer deckId) {
        this.deckId = deckId;
    }
}
