package commands;

import exceptions.DukeException;
import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a Command class which other commands will be derived from.
 * <p>
 * Commands are keyed in by the user, then goes through the parser where
 * the corresponding actions will be determined and executed.
 */

public class Command{
    protected boolean exit=false;

    public Boolean isExit(){
        return exit;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException{}

}