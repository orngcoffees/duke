package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;


public class EventCommand extends Command{
    String description;
    String startsAt;
    String endsAt;

    public EventCommand(String description, String startsAt, String endsAt){
    this.description=description;
    this.startsAt=startsAt;
    this.endsAt=endsAt;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Event e = new Event(description,startsAt,endsAt);
        tasks.addTask(e);
        ui.print("Got it. I've added this task:\n" + e.toString());
        ui.print("Now you have " + (tasks.tasks.size()) + " tasks in the list.");
        
        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception ex) {
            ui.print(ex.getMessage());
        }
    }
}