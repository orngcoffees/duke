package commands;

import exceptions.DukeExceptions;
import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a command to exit the application, prints a goodbye message.
 * 
 * @see Command
 */

public class ByeCommand extends Command{
    public void execute(TaskList tasks, Ui ui, Storage storage){
        super.exit=true;
        ui.print("Bye. Hope to see you again soon!");
    }
}



