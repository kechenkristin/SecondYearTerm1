import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * the entrance for the card game
 */
public class CardGame {

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




    // main method
    public static void main(String[] args) {
        CardGame cg = new CardGame();
        // scan number of players
        cg.getPlayerNum();
        cg.getPack();

        // load pack file
        // todo : implement wait notify.


    }

}
