package ui;

import java.util.Scanner;

public class Ui {

    public void printLogo(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);
    }
    public void printLoadingError(){
        System.out.println("Error loading tasks from file.");
    }

    public void printHello() {
        System.out.println("Hello! I'm Bob\nWhat can I do for you?");
    }

    public String readCommand(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void print(String msg){
        System.out.println(msg);
    }

}