package Task2;

import java.io.IOException;

public class FileWriteThread extends BasicThread implements FileWriteEventListener
{
    
    FileWriteThread() throws IOException {
        super("FileWriteThread_output.txt" );
    }
     
    public void eventOccured(FileWriteEvent evt) throws IOException {
        this.writeToFile(evt.getMessage());
    }
}
