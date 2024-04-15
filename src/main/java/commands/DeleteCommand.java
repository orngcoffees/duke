package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

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