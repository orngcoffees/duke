package exceptions;

public class IllegalIndexFormatException extends DukeException {
    public IllegalIndexFormatException() {
        super("oh no! Index not found. Please check your task index format (should be a number).");
    }
}