/**
 * Class to test method for player class
 */
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;


public class TestPlayer {
    /**
     * test CheckWin() method to be False if player has different cards
     */
    @Test
    public void testCheckWin1() {
        ConcurrentLinkedDeque<Card> cards = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            cards.add(new Card(i + 1));
        }
        Player player1 = new Player(1, cards);
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
     *  Check if the card was drawn from the top of the deck and player gets it
     *  deck: (bottom)1, 2, 3, 4(top) => 1, 2, 3
     *  player: empty => 4
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

        Player player1 = new Player(1, new ConcurrentLinkedDeque<>());
        player1.drawCard(deckList);

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








}
