package tasklist;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a tasklist which stores an arraylist of tasks.
 */
public class TaskList {
    public ArrayList<Task> tasks = new ArrayList<Task>();

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(File f) throws FileNotFoundException  {
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            read(s.nextLine());
        }
    }

    public void addTask(Task task){
        tasks.add(task);

    }
    public void removeTask(int task){
        tasks.remove(task);

    }

    public ArrayList<Task> read(String s){
        String[] inputArray = s.split(" \\| ");
        String identifier = inputArray[0];
        String isDone = inputArray[1];
        String description = inputArray[2];

        if (identifier.equals("T")) {
              tasks.add(new Todo(description));

              if(isDone.equals("1")) {
                  tasks.get(tasks.size()-1).markDone();
              }
        } 
        
        else if (identifier.equals("E")) {
            String[] atTimes = inputArray[3].split(" ");

            tasks.add(new Event(description,atTimes[0]+" "+atTimes[1]+" "+ atTimes[2]," "+ atTimes[3]));

            if(isDone.equals("1")) {
                tasks.get(tasks.size()-1).markDone();
            }
        }
        
        else if (identifier.equals("D")){
            String by = inputArray[3];
            tasks.add(new Deadline(description,by));

            if(isDone.equals("1")) {
                tasks.get(tasks.size()-1).markDone();
            }
        }

        else if (identifier.equals("F")){
            String duration = inputArray[3];
            tasks.add(new FixedDurationTask(description,duration));

            if(isDone.equals("1")) {
                tasks.get(tasks.size()-1).markDone();
            }
        }
        

        return tasks;
    }
}