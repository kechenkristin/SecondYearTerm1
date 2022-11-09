
import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;


/**
 * Test class for Player class
 * @version 1.0
 * @author kechen heegon
 */
public class PlayerTest {

    CardGame cardGame;

    /**
     * fields of test cases for player's cards
     */
    // 1, 2, 3, 4
    ConcurrentLinkedDeque<Card> playerCards1;

    // 1, 1, 1, 1
    ConcurrentLinkedDeque<Card> playerCards2;

    // large number
    ConcurrentLinkedDeque<Card> playerCards3;

    // 8, 7, 6 ,5 ,4 ,3, 2, 1
    ConcurrentLinkedDeque<Card> playerCards4;

    // 1, 2
    ConcurrentLinkedDeque<Card> playerCards5;

    // null
    ConcurrentLinkedDeque<Card> playerCards6;

    /**
     * fields for Player instance
     */
    CardGame.Player player1;    // draw form deck1, discard to deck2
    CardGame.Player player4;    // draw from deck4, discard to deck1;


    /**
     * fields for deck
     */
    CardDeck deck1;
    CardDeck deck2;
    CardDeck deck3;
    CardDeck deck4;

    /**
     * feields of a List of Deck for the CardGame class
     */
    List<CardDeck> deckList;

    /**
     * fields of test cases for deck's cards
     */
    // 1, 2, 3, 4
    ConcurrentLinkedDeque<Card> deckCards1;

    // 2, 2, 2, 2
    ConcurrentLinkedDeque<Card> deckCards2;

    // 888, 674, 996, 234
    ConcurrentLinkedDeque<Card> deckCards3;

    // 8, 7, 6 ,5 ,4 ,3, 2, 1
    ConcurrentLinkedDeque<Card> deckCards4;

    // 1, 2
    ConcurrentLinkedDeque<Card> deckCards5;

    // null
    ConcurrentLinkedDeque<Card> deckCards6;


    // configurate

    /**
     * set up test cases for each test method.
     */
    @Before
    public void setUp() {
        cardGame = new CardGame();
        cardGame.setNumOfPlayers(4);
        // player setup
        player1 = cardGame.new Player(1);
        player4 = cardGame.new Player(4);
        // 1, 2, 3, 4
        playerCards1 = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            playerCards1.add(new Card(i + 1));
        }

        // 1, 1, 1, 1
        playerCards2 = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            playerCards2.add(new Card(1));
        }

        // large number
        playerCards3 = new ConcurrentLinkedDeque<>();
        for (int i = 1; i < 5; i++) {
            playerCards3.add(new Card(i + i * 1000));
        }

        // 8, 7, 6 ,5 ,4 ,3, 2, 1
        playerCards4 = new ConcurrentLinkedDeque<>();
        for (int i = 8; i >= 1; i--) {
            playerCards4.add(new Card(i));
        }

        // 1, 2
        playerCards5 = new ConcurrentLinkedDeque<>();
        for (int i = 0; i <= 1; i++) {
            playerCards5.add(new Card(i + 1));
        }

        // null
        playerCards6 = new ConcurrentLinkedDeque<>();

        // set up deck
        deck1 = new CardDeck(1);
        deck3 = new CardDeck(3);
        deck2 = new CardDeck(2);
        deck4 = new CardDeck(4);

        deckList = new ArrayList<>();
        deckList.add(deck1);
        deckList.add(deck2);
        deckList.add(deck3);
        deckList.add(deck4);

        cardGame.setDecks(deckList);

        // 1, 2, 3, 4
        deckCards1 = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            deckCards1.add(new Card(i + 1));
        }

        // 2, 2, 2, 2
        deckCards2 = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 4; i++) {
            deckCards2.add(new Card(2));
        }

        // large number
        deckCards3 = new ConcurrentLinkedDeque<>();
        for (int i = 1; i < 5; i++) {
            deckCards3.add(new Card(i + i * 1000));
        }

        // 8, 7, 6 ,5 ,4 ,3, 2, 1
        deckCards4 = new ConcurrentLinkedDeque<>();
        for (int i = 8; i >= 1; i--) {
            deckCards4.add(new Card(i));
        }

        // 1, 2
        deckCards5 = new ConcurrentLinkedDeque<>();
        for (int i = 0; i <= 1; i++) {
            deckCards5.add(new Card(i + 1));
        }

        // null
        deckCards6 = new ConcurrentLinkedDeque<>();
    }

    @After
    public void remove() {
        cardGame = null;
        player1 = null;
        player4 = null;

        deck1 = null;
        deck2 = null;
        deck3 = null;
        deck4 = null;

        deckList = null;


        playerCards1 = null;
        playerCards2 = null;
        playerCards3 = null;
        playerCards4 = null;
        playerCards5 = null;
        playerCards6 = null;

        deckCards1 = null;
        deckCards2 = null;
        deckCards3 = null;
        deckCards4 = null;
        deckCards5 = null;
        deckCards6 = null;
    }


    /**
     * test CheckWin() method to be False if player has different cards
     */
    @Test
    public void testCheckWin1() {
        player1.setCards(playerCards1);
        assertFalse(player1.checkWin());
    }

    /**
     * test CheckWin() method to be True if player has same cards
     */
    @Test
    public void testCheckWin2() {
        player1.setCards(playerCards2);
        assertTrue(player1.checkWin());
    }

    /**
     * Check if the card was drawn from the top of the deck and player gets it
     * deck: (bottom)1, 2, 3, 4(top) => 1, 2, 3
     * player: empty => 4
     */
    @Test
    public void testDrawCard1() {
        deck1.setCards(deckCards1);
        try {
            player1.drawCard();
        } catch (Exception e) {
            System.out.println("ooops");
        }

        // test player's hand card is 4
        int[] ep = new int[]{4};
        int[] ap = new int[player1.getCards().size()];

        int i = 0;
        for (Card c : player1.getCards()) {
            ap[i] = c.getVal();
            i++;
        }
        assertArrayEquals(ep, ap);

        // test the deck is 1,2,3
        int[] ed = new int[]{1, 2, 3};
        int[] ad = new int[deckCards1.size()];
        int j = 0;
        for (Card c : deckCards1) {
            ad[j] = c.getVal();
            j++;
        }
        assertArrayEquals(ed, ad);
    }

    /**
     * Test if the deck is empty, the player caould not drawn card from.
     */
    @Test
    public void testDrawCard2() {
        try {
            player1.drawCard();
        } catch (Exception e) {
            System.out.println("The deck is empty");
        }
    }

    /**
     * test player's discard methods, if the player don't have cards in hand.
     */
    @Test
    public void testDiscard1() {
        deck1.setCards(deckCards1);
        try {
            player1.discardCard();
        } catch (Exception e) {
            System.out.println("the player don't have cards in hand.!");
        }
    }

    /**
     * test player's discard methods, if the player has 5 more cards in hand.
     */
    @Test
    public void testDiscard2() {

        player1.setCards(playerCards4);
        deck2.setCards(deckCards1);

        try {
            player1.discardCard();
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
        playerCards2.add(new Card(1));
        player1.setCards(playerCards2);

        deck2.setCards(deckCards1);

        try {
            player1.discardCard();
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
        playerCards1.add(new Card(5));
        player4.setCards(playerCards1);


        deck1.setCards(deckCards1);
        // create deck List

        try {
            player4.discardCard();
        } catch (Exception e) {
            System.out.println("oooops");
        }

        // assert
        // except for player
        int[] ep = new int[]{2, 3, 4, 5};

        // actual for player
        int i = 0;
        int[] ap = new int[player4.getCards().size()];
        for (Card c : player4.getCards()) {
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
