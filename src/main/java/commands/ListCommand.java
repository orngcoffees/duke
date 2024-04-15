package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

public class ListCommand extends Command{

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        System.out.println("Here are the tasks in your list: ");
        int i=0;
        while (i<tasks.tasks.size()){
            System.out.println(i+1 + ". " + tasks.tasks.get(i).toString());
            i++;
        }
    }

}