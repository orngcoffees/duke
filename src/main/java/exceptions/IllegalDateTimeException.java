package exceptions;

public class IllegalDateTimeException extends DukeException {
    public IllegalDateTimeException() {
        super("oh no! Wrong datetime format. Please follow this format: [d/MM/yyyy HHmm] e.g. 13/05/2024 1800");
    }
}
