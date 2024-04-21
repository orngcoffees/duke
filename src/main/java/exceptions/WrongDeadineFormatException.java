package exceptions;

public class WrongDeadineFormatException extends DukeException {
    public WrongDeadineFormatException() {
        super("oh no! Wrong format detected for deadline. Please follow this format: deadline [task] /by [date]");
    }
}