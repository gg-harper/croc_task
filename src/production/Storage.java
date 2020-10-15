package production;

import java.io.*;

public class Storage {
    private String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }
    synchronized void output(String data) {
        try (FileWriter outputStream = new FileWriter(fileName, true)){
                outputStream.write("Data " + data + " written by " + Thread.currentThread().getName() + "\n");  // write data to file
        }
        catch (FileNotFoundException exc) {
            System.out.println("File not found:" + exc.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        }

    }

