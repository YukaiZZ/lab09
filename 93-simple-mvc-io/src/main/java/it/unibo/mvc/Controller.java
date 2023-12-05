package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private final File defaultFile = new File(System.getProperty("user.home"), "output.txt");
    private File currentFile = defaultFile;

    /**
     * Sets the current file.
     *
     * @param currentFile The file to be set as the current file.
     */
    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }

    /**
     * Gets the current file.
     *
     * @return The current file.
     */
    public File getCurrentFile() {
        return currentFile;
    }

    /**
     * Gets the path of the current file.
     *
     * @return The path of the current file as a string.
     */
    public String getCurrentFilePath() {
        return currentFile.getPath();
    }

    /**
     * Saves the given content to the current file.
     *
     * @param content The content to be saved.
     * @throws IOException if an I/O error occurs.
     */
    public void save(final String content) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(this.currentFile), StandardCharsets.UTF_8)) {
            writer.write(content);
        }
    }
}
