import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        
        String response;
        String list[] = new String[100];
        int responseCount = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Bob\nWhat can I do for you?");
        while (true){
            response = in.nextLine();
            responseCount++;

            if (response.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }

            else if (response.equals("list")){
                int i=1;
                while (i<responseCount){
                    System.out.println(i + ". " + list[i]);
                    i++;
                }
            }
            else{
                System.out.println(response);
                list[responseCount]=response;
            }
        }
        
    }
}
