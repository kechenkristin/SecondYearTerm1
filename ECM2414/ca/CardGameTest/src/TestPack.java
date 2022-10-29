import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TestPack {

    String fileLocation;

    int numOfPlayers = 2;
    /**
     * get the pack for the card game.
     */
    public void getPack() {
        scanFileLocation();
        readPackFile(fileLocation);
    }

    private void scanFileLocation() {
        System.out.println("Please enter location of pack to load : ");
        Scanner scanner = new Scanner(System.in);
        this.fileLocation = scanner.next();
    }

    /**
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

    // todo : implement wait until for informing
    /**
     * If the pack is invalid, inform the user and request a valid pack file
     */
    private void informUser() {
        System.out.println("The pack is invalid. Please provide a valid pack location.");
    }


    // main method
    public static void main(String[] args) {

        TestPack tp = new TestPack();
        tp.getPack();
    }
}
