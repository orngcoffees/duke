package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a specific command to create a Task of type Todo
 * and add the task to the tasklist. 
 * Deadline commands start with the keyword "todo".
 * 
 * @param description The exact task.

 * @see Command
 */

public class TodoCommand extends Command{
    String description;
    /**
     * Create TodoCommand
     */
    public TodoCommand(String description){
    this.description=description;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Todo t = new Todo(description);
        tasks.addTask(t);
        ui.print("Got it. I've added this task:\n" + t.toString());
        ui.print("Now you have " + (tasks.tasks.size()) + " tasks in the list.");
        
        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception e) {
            ui.print(e.getMessage());
        }
    }
}