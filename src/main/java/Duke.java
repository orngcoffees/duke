import commands.*;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import tasklist.*;
import ui.Ui;

import java.io.FileNotFoundException;

/**
* The Duke program implements an application that supports users with task management.
* It provides features including adding and deleting different types of tasks, 
* and supports additional functionalities such as storage and searching.
* <p>
* To use Duke, run the main method in this class. Then, provide Duke the commands
* in the Command Line Interface (CLI).
*
* @author  orngcoffees
* @version 2.6
* @since 2024-04-20
*/
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
    * Initialises Storage which is used to store a tasklist,
    * then checks if there is a tasklist inside.
    * If there is no tasklist found, create a new tasklist.
    */    
    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());

        } catch (FileNotFoundException e) {
            ui.printLoadingError();
            tasks = new TaskList();
        }
    }

    /**
    * The main method which initialises Duke program. Prints the Duke logo and
    * welcome message.
    * <p>
    * Reads user commands upon initialisation.
    */  
    public void run() {
        ui.printLogo();
        ui.printHello();
        ui.print("__________________________________________");
        
        boolean exit = false;
        while (!exit) {
            try {
                String response = ui.readCommand();
                Command c = Parser.parse(response);
                ui.print("__________________________________________");
                c.execute(tasks, ui, storage);
                ui.print("__________________________________________");
                exit = c.isExit();

            } catch (IndexOutOfBoundsException e) {
                ui.print(e.getMessage());
            } 
        }

    }
    /**
    * The method which runs to check existing storage.
    */  
    public static void main(String[] args) {
        new Duke("../Duke/src/main/java/data/duke.txt").run();

    }
}