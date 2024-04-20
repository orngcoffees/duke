package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a specific command to remove a created task from the tasklist.
 * Delete commands start with the keyword "delete", followed by the task index to be deleted.
 * 
 * @param delIndex The index of the task to be deleted
 * 
 * @see Command
 */

public class DeleteCommand extends Command {
    int delIndex;

    public DeleteCommand(String index) {
        delIndex = Integer.parseInt(index)-1;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){
        Task deletedTask = tasks.tasks.get(delIndex);
        tasks.removeTask(delIndex);
        ui.print("Noted. I've removed this task:\n" + deletedTask.toString());
        ui.print("Now you have " + tasks.tasks.size() + " tasks in the list.");
        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception e) {
            ui.print(e.getMessage());
        }

    }

}