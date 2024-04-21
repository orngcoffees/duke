import commands.*;
import exceptions.*;
import parser.Parser;
import storage.Storage;
import tasklist.*;
import ui.Ui;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
* The Duke program implements an application that supports users with task management.
* It provides features including adding and deleting different types of tasks, 
* and supports additional functionalities such as storage and searching.
* <p>
* To use Duke, run the main method in this class. Then, provide Duke the commands
* in the Command Line Interface (CLI).
*
* @author  orngcoffees
* @version 2.14
* @since 2024-04-21
*/
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
    * Initialises Storage which is used to store a tasklist,
    * then checks if there is a tasklist inside.
    * If there is no tasklist found, create a new tasklist.
     * @throws FileNotFoundException 
    */    
    public Duke(String filePath) throws FileNotFoundException {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());

        } catch (FileNotFoundException e)  {
            tasks = new TaskList();
        }
    }

    /**
    * The main method which initialises Duke program. Prints the Duke logo and
    * welcome message.
    * <p>
    * Reads user commands upon initialisation.
    */  
    public void run() throws DukeException, IllegalIndexNumberException,IOException {
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
                Storage.save("data/duke.txt", tasks.tasks);
                ui.print("__________________________________________");
                exit = c.isExit();

            } catch (DukeException e) {
                //ui.print(e.getErrorMessage());
                ui.print("__________________________________________");
            } 
        }

    }
    /**
    * The method which runs to start the process.
     * @throws IOException 
     * @throws DukeException 
     * @throws IllegalIndexNumberException 
    */  
    public static void main(String[] args) throws IllegalIndexNumberException, DukeException, IOException {
        new Duke("data/duke.txt").run();
    }
}