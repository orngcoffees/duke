package exceptions;

public class IllegalIndexNumberException extends DukeException {
    public IllegalIndexNumberException() {
        super("oh no! Index not found. Please check your task index number (should be within task list).");
    }
}
