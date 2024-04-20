package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a specific command to unmark a certain task as completed (marks it as not completed again).
 * Unmark commands start with the keyword "unmark", followed by the index of the task to be unmarked.
 * 
 * @param markIndex The index of the task to be unmarked completed/
 * 
 * @see Command
 */

public class UnmarkCommand extends Command{
    int unmarkIndex;

    public UnmarkCommand(String index){
        unmarkIndex=Integer.parseInt(index)-1;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task unmarkedTask = tasks.tasks.get(unmarkIndex);
        unmarkedTask.unmarkDone();
        ui.print("OK, I've marked this task as not done yet:\n"+unmarkedTask.toString());
        
        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception e) {
            ui.print(e.getMessage());
        }
    }
}
