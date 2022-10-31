import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Handle player's out_put file
 */
public class PlayerFileHandler extends FileHandler{

    private File file;

    public File getFile() {
        return file;
    }


    // constructor
    public PlayerFileHandler(int playerId) {
        try
        {
            file = new File("player"+ playerId + "_output.txt");
            (new BufferedWriter(new FileWriter(file.getAbsoluteFile()))).write("");
        } catch (IOException e) {System.out.println("Error");}
    }

    // methods
    public void write(String msg) {
        super.write(msg);
    }
}
