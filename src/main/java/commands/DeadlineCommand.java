package commands;

import exceptions.DukeExceptions;
import storage.Storage;
import tasklist.*;
import ui.Ui;


public class DeadlineCommand extends Command{
    String description;
    String by;

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
