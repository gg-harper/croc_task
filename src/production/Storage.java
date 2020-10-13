package production;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Storage {
    private String fileName;
    private FileOutputStream outputStream;

    public Storage(String fileName) {
        this.fileName = fileName;
    }
     void output(int data) {
        try {
             outputStream = new FileOutputStream(fileName, true); //open output stream to file with append option
            synchronized (outputStream) {

                outputStream.write(data);               // write data to file
                outputStream.close();                   // close stream
            }
        }
        catch (FileNotFoundException exc) {
            System.out.println("File not found:" + exc.getMessage());
        }
        catch (IOException e) {
            System.out.println("Something went terribly wrong... :" + e.getMessage());
        }
    }
}
