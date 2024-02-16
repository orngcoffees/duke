import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        
        String response;
        Task tasks[] = new Task[100];
        int taskCount = 1;

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
                int i=1;
                while (i<taskCount){
                    System.out.println("[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
                    i++;
                }
            }

            else if (response.startsWith("mark")){ //mark
                int taskIndex=Integer.parseInt(response.split(" ")[1]);
                if (taskIndex <= taskCount && taskIndex > 0) {
                    tasks[taskIndex].markDone();
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println("[" + tasks[taskIndex].getStatusIcon() + "] " + tasks[taskIndex].description);
                }                
            }

            else if (response.startsWith("unmark")){ //unmark
                int taskIndex=Integer.parseInt(response.split(" ")[1]);
                if (taskIndex <= taskCount && taskIndex > 0) {
                    tasks[taskIndex].unmarkDone();
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println("[" + tasks[taskIndex].getStatusIcon() + "] " + tasks[taskIndex].description);
                }
            }

            else{ //add task
                System.out.println("added:" + response);
                tasks[taskCount]=new Task(response);
                taskCount++;
            }
        }
        
    }
}

