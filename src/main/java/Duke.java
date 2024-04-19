import commands.*;
import exceptions.DukeExceptions;
import parser.Parser;
import storage.Storage;
import tasklist.*;
import ui.Ui;

import java.io.FileNotFoundException;


public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

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

    public void run() {
        ui.printLogo();
        ui.printHello();
        ui.print("__________________________________________");
        
        boolean exit = false;
        while (!exit) {
            try {
                String response = ui.readCommand();
                Command c = Parser.parse(response);
                c.execute(tasks, ui, storage);
                ui.print("__________________________________________");
                exit = c.isExit();

            } catch (IndexOutOfBoundsException e) {
                ui.print(e.getMessage());
            } 
        }

    }
    public static void main(String[] args) {
        new Duke("../Duke/src/main/java/data/duke.txt").run();

    }
}