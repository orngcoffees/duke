package exceptions;

public class IllegalDateException extends DukeException{
    public IllegalDateException() {
        super("oh no! Wrong date format. Please follow this format: [d/MM/yyyy] e.g. 13/05/2024");
    }
}