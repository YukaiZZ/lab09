package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    final private File defaultFile = new File("user,home", "output.txt");
    private File currentFile = defaultFile;

    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }

    public File getCurrentFile(){
        return currentFile;
    }

    public String getCurrentFilePath(){
        return currentFile.getPath();
    }

    public void save(final String content) throws IOException{

        try(FileWriter w = new FileWriter(this.currentFile))
        {
            w.write(content);
        }
    }
}