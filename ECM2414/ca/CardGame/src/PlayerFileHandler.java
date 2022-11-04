import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handle player's out_put file
 */
public class PlayerFileHandler {

    private File file;

    // constructor
    public PlayerFileHandler(int playerId) {
        try {
            file = new File("player" + playerId + "_output.txt");
            (new BufferedWriter(new FileWriter(file.getAbsoluteFile()))).write("");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    // methods
    public void write(String msg) {
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true); //'true' is set to append on the file
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append(msg);
            bw.newLine();
            bw.close();
        } catch (IOException ignored) {
        }
    }
}
