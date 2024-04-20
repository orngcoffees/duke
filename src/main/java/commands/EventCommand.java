package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

/**
 * Represents a specific command to create a Task of type Event
 * and add the task to the tasklist. 
 * Event commands start with the keyword "event", followed by "/from" and "/to", each with the corresponding 
 * dates or times behind.
 * 
 * @param description The exact task.
 * @param startsAt The time at which the event starts.
 * @param endsAt The time at which the event ends.
 * 
 * @see Command
 */

public class EventCommand extends Command{
    String description;
    String startsAt;
    String endsAt;

    /**
     * Create EventCommand
     * 
     * @param description The exact task.
     * @param startsAt The time at which the event starts.
     * @param endsAt The time at which the event ends.
     * 
     */
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