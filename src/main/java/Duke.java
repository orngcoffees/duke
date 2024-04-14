import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Duke {
    public static List<Task> taskList = new ArrayList<>();
    public static void main(String[] args) {
        
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        
        String response;
        Task tasks[] = new Task[100];
        int taskCount = 0;

        int c=0;
            while (c<taskCount){
                taskList.add(tasks[taskCount]);
                c++;
            }

        Scanner in = new Scanner(System.in);

        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Bob\nWhat can I do for you?");
        while (true){
            response = in.nextLine();

            if (response.equals("bye")){ //bye
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (response.equals("list")){ //list
                int i=0;
                System.out.println("Here are the tasks in your list: ");
                while (i<taskCount){
                    System.out.println(i+1 + ". " + tasks[i].toString());
                    i++;
                }
            }

            else if (response.startsWith("mark")){ //mark
                int taskIndex=Integer.parseInt(response.split(" ")[1]);
                if (taskIndex <= taskCount && taskIndex > 0) {
                    tasks[taskIndex-1].markDone();
                    System.out.println("Nice! I've marked this task as done: ");
                    System.out.println(tasks[taskIndex-1].toString());
                }          
            }

            else if (response.startsWith("unmark")){ //unmark
                int taskIndex=Integer.parseInt(response.split(" ")[1]);
                if (taskIndex <= taskCount && taskIndex > 0) {
                    tasks[taskIndex-1].unmarkDone();
                    System.out.println("OK, I've marked this task as not done yet: ");
                    System.out.println(tasks[taskIndex-1].toString());
                }
            }

            else if (response.startsWith("todo")){ //todo
                String tline = response.substring(4);
                if (tline.length()==0){
                    throw new IndexOutOfBoundsException("! The description of a todo cannot be empty.");
                }
                Todo t = new Todo(response.substring(4));
                tasks[taskCount] = t;
                taskCount++;
                taskList.add(t);
                System.out.println("Got it. I've added this task:\n" + t.toString()); 
                System.out.println("Now you have " + taskCount + " tasks in the list."); 
            }

            else if (response.startsWith("event")){ //event
                
                int firstSlashIndex = response.indexOf("/");
                String description = response.substring(5,firstSlashIndex);

                String[] atTimes = response.split("/");
                String startsAt = atTimes[1].replace("from ", ""); 
                String endsAt = atTimes[2].replace("to ", ""); ; 
                Event e = new Event(description, startsAt, endsAt);

                tasks[taskCount] = e;
                taskList.add(e);
                taskCount++;
                System.out.println("Got it. I've added this task:\n" + e.toString()); 
                System.out.println("Now you have " + taskCount + " tasks in the list.");
            }

            else if (response.startsWith("deadline")){ //deadline
                int firstSlashIndex = response.indexOf("/");
                String description = response.substring(8,firstSlashIndex);
                String by = response.substring(firstSlashIndex+4);

                Deadline d = new Deadline(description, by);

                tasks[taskCount] = d;
                taskList.add(d);
                taskCount++;
                System.out.println("Got it. I've added this task:\n" + d.toString()); 
                System.out.println("Now you have " + taskCount + " tasks in the list.");
            }
            else if (response.startsWith("delete")){
                int delIndex = Integer.parseInt(response.split(" ")[1]);
                Task deletedTask = tasks[delIndex-1];
                if (delIndex <= taskCount && delIndex > 0) {
                    for (int i = delIndex - 1; i < taskCount - 1; i++) {
                        tasks[i] = tasks[i + 1];
                    }
                    taskCount--;
                    System.out.println("Noted. I've removed this task:\n" + deletedTask.toString()); 
                    System.out.println("Now you have " + taskCount + " tasks in the list.");
                }
                taskList.remove(delIndex-1);
            }

            else{ // don't add task
                // System.out.println("added: " + response); 
                // tasks[taskCount]=new Task(response);
                // taskCount++;
                throw new IndexOutOfBoundsException("? I'm sorry, but I don't know what that means :^(");
                
            }
        }
        Storage.main();
    }
}

