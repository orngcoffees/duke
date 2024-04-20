package exceptions;

/**
 * Represents an Exception class which other Duke-related exceptions will be built upon.
 */

public class DukeException extends Exception{
    public String errorMessage;

    public DukeException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }
}
