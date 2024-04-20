package exceptions;

public class IllegalIndexException extends DukeException {
    public IllegalIndexException() {
        super("oh no! Index not found. Please check your task index.");
    }
}
