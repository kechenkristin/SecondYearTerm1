

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Test class for CardGame class
 * @version 1.0
 * @author kechen heegon
 */
public class CardGameTest {
    CardGame cardGame;
    List<CardGame.Player> players;
    List<CardDeck> decks;
    List<Card> pack;

    CardGame cardGame2;

    /**
     * init and configuration for cardgame
     */
    @Before
    public void init() {
        cardGame = new CardGame();
        cardGame.setNumOfPlayers(4);
        pack = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            pack.add(new Card((i % 6) + 1));
        }
        cardGame.setPack(pack);
        cardGame.initPlayersAndDecks();

        cardGame2 = new CardGame();
        cardGame2.setNumOfPlayers(4);
    }

    @After
    public void remove() {
        cardGame = null;
        pack = null;
    }

    /**
     * test, if initial successfully, the number of players and decks should be 4
     */
    @Test
    public void testInitPlayerAndDecks() {
        assertEquals(4, cardGame.getNumOfPlayers());
        assertEquals(4, cardGame.getPlayers().size());
        assertEquals(4, cardGame.getDecks().size());
    }

    /**
     * test dealCardForPlayer method
     */
    @Test
    public void testDealCardforPlayer() {
        cardGame.dealCardForPlayer();
        cardGame.generateInitHand();

        //each player has 4 cards in their hand
        assertEquals(4, cardGame.getPlayers().get(0).getCards().size());
    }

    /**
     * test dealCardForDeck method
     */
     @Test
    public void testDealCardforDeck() {
        cardGame.dealCardForDeck();
        // each deck has 4 cards
         assertEquals(4, cardGame.getDecks().get(2).getCards().size());
    }

    /*
    test a game scenario
     */
    @Test
    public void testStartGame() {
         cardGame2.readPackFile("test.txt");
         cardGame2.initPlayersAndDecks();
         cardGame2.dealCardForPlayer();
         cardGame2.generateInitHand();
         cardGame2.dealCardForDeck();
         cardGame2.runPlayer();
    }


}
