package exceptions;

public class MissingInputException extends DukeException {
    public MissingInputException() {
        super("oh no! Missing input detected. Please check your command.");
    }
}
