package ui;

import java.util.Scanner;

/**
* Manages the user interface (which is a CLI) which is displayed.
* Includes various helper functions for displaying messages or prompts to the user.
*/
public class Ui {

    public void printLogo(){
        String logo = "    _               _     \n"
                + "   | |__     ___   | |__  \n"
                + "   | '_ \\   / _ \\  | '_ \\ \n"
                + "   | |_) | | (_) | | |_) |\n"
                + "   |_.__/   \\___/  |_.__/ \n";
        System.out.println(logo);
    }
    public void printLoadingError(){
        System.out.println("Error loading tasks from file. D:");
    }

    public void printHello() {
        System.out.println("Hello! I'm Bob :D\nWhat can I do for you?");
    }

    public String readCommand(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void print(String msg){
        System.out.println(msg);
    }

}