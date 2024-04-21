package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;
import exceptions.*;

/**
 * Represents a specific command to mark a certain task as completed
 * Mark commands start with the keyword "mark", followed by the index of the task to be marked completed.
 * 
 * @param markIndex The index of the task to be marked completed/
 * 
 * @see Command
 */

public class MarkCommand extends Command{
    int markIndex;

    public MarkCommand(String index){
        markIndex = Integer.parseInt(index)-1;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws IllegalIndexException {
        try{
            Task markedTask = tasks.tasks.get(markIndex);
            markedTask.markDone();
            ui.print("Nice! I've marked this task as done:\n"+markedTask.toString());
        } catch (IndexOutOfBoundsException e){
            throw new IllegalIndexException();
        }

        try {
            storage.writeToFile(tasks.tasks);
        } catch (Exception e) {
            ui.print(e.getMessage());
        }
    }
}
