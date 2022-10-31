import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class FileHandler {
    private File file;


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
