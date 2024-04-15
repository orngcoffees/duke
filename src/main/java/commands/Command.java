package commands;

import storage.Storage;
import tasklist.*;
import ui.Ui;

public class Command{
    protected boolean exit=false;

    public Boolean isExit(){
        return exit;
    }

    public void execute(TaskList tasks, Ui ui, Storage storage){}

}