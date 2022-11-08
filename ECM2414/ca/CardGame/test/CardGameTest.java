

import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CardGameTest {
    CardGame cardGame;
    List<CardGame.Player> players;
    List<CardDeck> decks;
    List<Card> pack;

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
    }

    @After
    public void remove() {
        cardGame = null;
        pack = null;
    }

    @Test
    public void testInitPlayerAndDecks() {
        cardGame.initPlayersAndDecks();
    }

    @Test
    public void testDealCardforPlayer() {
        cardGame.dealCardForPlayer();
        cardGame.generateInitHand();
    }

     @Test
    public void testDealCardforDeck() {
        cardGame.dealCardForDeck();
    }



}
