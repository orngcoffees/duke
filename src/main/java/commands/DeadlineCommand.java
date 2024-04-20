package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a specific command to create a Task of type Deadline
 * and add the task to the tasklist. 
 * Deadline commands start with the keyword "deadline", followed by "/by" and the corresponding DateTime.
 * 
 * @param description The exact task.
 * @param by The deadline which the task should be completed by.
 * 
 * @see Command
 */

public class DeadlineCommand extends Command{
    String description;
    String by;
    /**
     * Create DeadlineCommand
     * 
     * @param description The exact task.
     * @param by The deadline which the task should be completed by.
     */
    public DeadlineCommand(String description, String by){
    this.description=description;
    this.by=by;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Deadline d = new Deadline(description, by);
        tasks.addTask(d);
        ui.print("Got it. I've added this task:\n" + d.toString());
        ui.print("Now you have " + (tasks.tasks.size()) + " tasks in the list.");
        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception e) {
            ui.print(e.getMessage());
        }
    }
}
