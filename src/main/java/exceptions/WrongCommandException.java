package exceptions;

public class WrongCommandException extends DukeException {
    public WrongCommandException() {
        super("oh no! I don't understand your command. Please try: todo\\event\\deadline\\fixed\\mark\\unmark\\delete\\find\\list\\schedule\\bye");
    }
}