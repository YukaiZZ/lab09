package it.unibo.mvc;

import java.util.List;

/**
 * just a controller.
 */
public interface Controller {
    /**
     * set the next Sting to print.
     * @param arg The Sring to be set
     */
    void setNextString(String arg);

    /**
     * get the Next String.
     * @return the Next String
     */
    String getNextString();

    /**
     * get the history printed String.
     * @return the List that contented the history printed String 
     */
    List<String> getHistoryPrinted();

    /**
     * print the current String and add in to the History List.
     * @throw if the currentString is NULL
     */
    void printsCurrentString();

}
