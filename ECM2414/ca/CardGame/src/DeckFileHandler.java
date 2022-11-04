import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeckFileHandler {
    private File file;


    // constructor
    public DeckFileHandler(int deckId) {
        try {
            file = new File("deck" + deckId + "_output.txt");
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
