import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DeckFileHandler extends FileHandler {
    private File file;

    public File getFile() {
        return file;
    }

    // constructor
    public DeckFileHandler(int deckId) {
        try {
            File file = new File("deck" + deckId + "_output.txt");
            (new BufferedWriter(new FileWriter(file.getAbsoluteFile()))).write("");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    // methods
    public void write(String msg) {
        super.write(msg);
    }
}
