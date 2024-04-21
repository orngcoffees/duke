package commands;

import storage.Storage;
import tasklist.TaskList;
import ui.Ui;

/**
 * Represents a specific command to list the schedule for a given date.
 * Applies to deadlines only.
 * 
 * @param scheduleDate The date to show the schedule for.
 * 
 * @see Command
 */

public class ScheduleCommand extends Command {
    String scheduleDate;

    public ScheduleCommand(String scheduleDate){
        this.scheduleDate=scheduleDate;
        }
    /**
     * Search for task with matching date and store in tasksFound.
     * Then, loop through the list and print them out to user.
     * 
     * @param tasksFound The list of tasks found.
     * @param scheduleDate The date to search and show the schedule for.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        TaskList tasksFound = new TaskList();
        int i=0;
        
        while (i<tasks.tasks.size()){
            String toSearch=tasks.tasks.get(i).toString();

            if(toSearch.contains(scheduleDate)){
                tasksFound.addTask(tasks.tasks.get(i));
            }
            i++;
        }

        if (tasksFound.tasks.size()==0){
            System.out.println("No tasks for the date: " + scheduleDate);
        }

        else {
            System.out.println("Here are the tasks for the date: " + scheduleDate);
            for (int j=0;j<tasksFound.tasks.size();j++){
                System.out.print(Integer.toString(j+1)+". ");
                System.out.println(tasksFound.tasks.get(j));
            }
        }
    }
}
