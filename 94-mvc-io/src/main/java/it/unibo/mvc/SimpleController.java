package it.unibo.mvc;

import java.util.Objects;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String currentString;
    private final List<String> history = new ArrayList<>();

    /**
     * set the next Sting to print.
     * @param arg The Sring to be set
     */
    @Override
    public void setNextString(final String arg) {
        currentString = Objects.requireNonNull(arg, "The arg can not be NULL");
    }
    /**
     * get the Next String.
     * @return the Next String
     */
    @Override
    public String getNextString() {
        return currentString;
    }

    /**
     * get the history printed String.
     * @return the List that contented the history printed String 
     */
    @Override
    public List<String> getHistoryPrinted() {
        return new ArrayList<>(history); 
    }

    /**
     * print the current String and add in to the History List.
     * @throw if the currentString is NULL
     */
    @Override
    public void printsCurrentString() {
        if (currentString == null) {
            throw new IllegalStateException("Current string is unset");
        }
        history.add(this.currentString);
        System.out.println(this.currentString); // NOPMD: allowed in exercises
    }
}
