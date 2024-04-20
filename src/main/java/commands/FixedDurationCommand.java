package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a specific command to create a Task of type Fixed Duration
 * and add the task to the tasklist. 
 * Fixed Duration commands start with the keyword "fixed", followed by "/needs" and the allocated time.
 * 
 * @param description The exact task.
 * @param duration The time which is required to complete the task.
 * 
 * @see Command
 */
public class FixedDurationCommand extends Command {
    String description;
    String duration;

    /**
     * Create FixedDurationCommand
     * 
     * @param description The exact task.
     * @param duration The time which is required to complete the task.
     * 
     */
    public FixedDurationCommand(String description, String duration){
    this.description=description;
    this.duration=duration;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        FixedDurationTask f = new FixedDurationTask(description,duration);
        tasks.addTask(f);
        ui.print("Got it. I've added this task:\n" + f.toString());
        ui.print("Now you have " + (tasks.tasks.size()) + " tasks in the list.");
        
        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception e) {
            ui.print(e.getMessage());
        }
    }
}
