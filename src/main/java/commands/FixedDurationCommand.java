package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;


public class FixedDurationCommand extends Command {
    String description;
    String duration;

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
