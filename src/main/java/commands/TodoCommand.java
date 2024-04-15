package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;


public class TodoCommand extends Command{
    String description;

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