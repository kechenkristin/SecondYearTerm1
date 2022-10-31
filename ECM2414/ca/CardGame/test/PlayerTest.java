
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.concurrent.ConcurrentLinkedDeque;

public class PlayerTest {

    CardGame cardGame;

    // configurate
    @BeforeClass
    public void setUp() {
        cardGame = new CardGame();
    }
     /**
     * test CheckWin() method to be False if player has different cards
     */
    @Test
    public void testCheckWin1() {
        ConcurrentLinkedDeque<Card> cards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(i + 1));
        }
        CardGame.Player player1 = cardGame.new Player(1, cards);
        assertFalse(player1.checkWin());
    }

    /**
     * test CheckWin() method to be True if player has same cards
     */
    @Test
    public void testCheckWin2() {
        ConcurrentLinkedDeque<Card> cards2 = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            cards2.add(new Card(2));
        }
        Player player2 = new Player(2, cards2);
        assertTrue(player2.checkWin());
    }

    /**
     * Check if the card was drawn from the top of the deck and player gets it
     * deck: (bottom)1, 2, 3, 4(top) => 1, 2, 3
     * player: empty => 4
     */
    @Test
    public void testDrawCard1() {
        ConcurrentLinkedDeque<Card> DeckCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            DeckCards.add(new Card(i + 1));
        }

        CardDeck deck = new CardDeck(1, DeckCards);
        List<CardDeck> deckList = new ArrayList<>();
        deckList.add(deck);

        Player player1 = new Player(1);

        try {
            player1.drawCard(deckList);
        } catch (Exception e) {
            System.out.println("ooops");
        }

        // test player's hand card is 4
        int expect = 4;
        int actual = player1.cards.getFirst().getVal();
        assertEquals(expect, actual);

        // test the value for DeckCard after the player has drawn one
        int[] expect1 = new int[]{1, 2, 3};
        int[] actual1 = new int[3];

        int i = 0;
        for (Card c : DeckCards) {
            actual1[i] = c.getVal();
            i++;
        }

        for (int j = 0; j < expect1.length; j++) {
            assertEquals(expect1[j], actual1[j]);
        }
    }

    /**
     * Test if the deck is empty, the player caould not drawn card from.
     */
    @Test
    public void testDrawCard2() {
        CardDeck deck = new CardDeck(1);
        List<CardDeck> deckList = new ArrayList<>();
        deckList.add(deck);
        Player player1 = new Player(1);

        try {
            player1.drawCard(deckList);
        } catch (Exception e) {
            System.out.println("The deck is empty");
        }
    }

    /**
     * 1, 2, 3, 4 => 2
     */
    @Test
    public void testfindNonPerferCard1() {
        ConcurrentLinkedDeque<Card> cards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(i + 1));
        }
        Player player1 = new Player(1, cards);

        int ac = player1.findNonPreferCard().getVal();
        assertEquals(2, ac);
    }

    /**
     * 1, 1, 1, 1 => null
     */
    @Test
    public void testfindNonPerferCard2() {
        ConcurrentLinkedDeque<Card> cards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(1));
        }
        Player player1 = new Player(1, cards);

        assertNull(player1.findNonPreferCard());
    }

    /**
     * test player's discard methods, if the player don't have cards in hand.
     */
    @Test
    public void testDiscard1() {
        // create a player
        Player p1 = new Player(1);

        int nop = 4;

        // create deck List
        ConcurrentLinkedDeque<Card> DeckCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            DeckCards.add(new Card(i + 1));
        }

        CardDeck deck = new CardDeck(1, DeckCards);
        List<CardDeck> deckList = new ArrayList<>();
        deckList.add(deck);

        try {
            p1.discardCard(deckList, nop);
        } catch (Exception e) {
            System.out.println("othe player don't have cards in hand.!");
        }
    }

    /**
     * test player's discard methods, if the player has 5 more cards in hand.
     */
    @Test
    public void testDiscard2() {
        // create a player
        ConcurrentLinkedDeque<Card> playerCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 99; i++) {
            playerCards.add(new Card(i + 1));
        }
        Player p1 = new Player(1, playerCards);

        int nop = 4;

        // create deck List
        ConcurrentLinkedDeque<Card> DeckCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            DeckCards.add(new Card(i + 1));
        }

        CardDeck deck = new CardDeck(1, DeckCards);
        List<CardDeck> deckList = new ArrayList<>();
        deckList.add(deck);

        try {
            p1.discardCard(deckList, nop);
        } catch (Exception e) {
            System.out.println(" the player has 5 more cards in hand");
        }
    }

    /**
     * test player's discard methods, if the player has achieved the win condition.
     */
    @Test
    public void testDiscard3() {
        // create a player
        ConcurrentLinkedDeque<Card> playerCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            playerCards.add(new Card(5));
        }
        Player p1 = new Player(1, playerCards);

        int nop = 4;

        // create deck List
        ConcurrentLinkedDeque<Card> DeckCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            DeckCards.add(new Card(i + 1));
        }

        CardDeck deck = new CardDeck(1, DeckCards);
        List<CardDeck> deckList = new ArrayList<>();
        deckList.add(deck);

        try {
            p1.discardCard(deckList, nop);
        } catch (Exception e) {
            System.out.println("ooops!");
        }
    }

    /**
     * test player's discard methods
     * P : 1, 2, 3, 4, 5 -> 2, 3, 4, 5
     * D : 1, 2, 3, 4 -> 1, 1, 2, 3, 4
     */
    @Test
    public void testDiscard4() {
        // create a player
        ConcurrentLinkedDeque<Card> playerCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 5; i++) {
            playerCards.add(new Card(i + 1));
        }
        Player p4 = new Player(4, playerCards);

        int nop = 4;

        // create deck List
        ConcurrentLinkedDeque<Card> DeckCards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            DeckCards.add(new Card(i + 1));
        }

        CardDeck deck1 = new CardDeck(1, DeckCards);
        List<CardDeck> deckList = new ArrayList<>();
        deckList.add(deck1);

        for (int i = 1; i < 4; i++) {
            deckList.add(new CardDeck(i + 1));
        }

        try {
            p4.discardCard(deckList, nop);
        } catch (Exception e) {
            System.out.println("oooops");
        }

        // assert
        // except for player
        int[] ep = new int[]{2, 3, 4, 5};

        // actual for player
        int i = 0;
        int[] ap = new int[p4.getCards().size()];
        for (Card c : p4.getCards()) {
            ap[i] = c.getVal();
            i++;
        }

        for (int j = 0; j < ep.length; j++) {
            assertEquals(ep[j], ap[j]);
        }

         // except for deck
        int[] ed = new int[]{1, 1, 2, 3, 4};
        // actual for deck
        int x = 0;
        int[] ad = new int[deck1.getCards().size()];
        for (Card c : deck1.getCards()) {
            ad[x] = c.getVal();
            x++;
        }
      assertArrayEquals(ed, ad);
    }

}
