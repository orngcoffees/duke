package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

public class MarkCommand extends Command{
    int markIndex;
    public MarkCommand(String index){
        markIndex = Integer.parseInt(index)-1;
    }
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task markedTask = tasks.tasks.get(markIndex);
        markedTask.markDone();
        ui.print("Nice! I've marked this task as done:\n"+markedTask.toString());

        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception e) {
            ui.print(e.getMessage());
        }
    }
}
