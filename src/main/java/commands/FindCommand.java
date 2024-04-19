package commands;

import java.util.ArrayList;

import storage.Storage;
import tasklist.Task;
import tasklist.TaskList;
import ui.Ui;

public class FindCommand extends Command{
    String toFind;

    public FindCommand(String toFind){
        this.toFind=toFind;
        }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        TaskList tasksFound = new TaskList();
        int i=0;
        while (i<tasks.tasks.size()){
            String toSearch=tasks.tasks.get(i).toString();

            if(toSearch.contains(toFind)){
                tasksFound.addTask(tasks.tasks.get(i));
            }
            i++;
        }

        if (tasksFound.tasks.size()==0){
            System.out.println("No matching tasks in your list.");
        }

        else {
            System.out.println("Here are the matching tasks in your list: ");
            for (int j=0;j<tasksFound.tasks.size();j++){
                System.out.print(Integer.toString(j+1)+". ");
                System.out.println(tasksFound.tasks.get(j));
            }
        }
    }
}
