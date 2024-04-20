package storage;

import tasklist.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a Storage class which is used to storing the tasklist in the hard disk.
 * Used for loading current tasklist during initialisation and real-time updating
 * of new tasks when they are added.
 */

public class Storage {
    private static File file;

    public Storage(String filePath){
        this.file= new File(filePath);
    }

    public File load() {
        return file;
    }

    public void writeToFile(ArrayList<Task> tasks) throws IOException {
        FileWriter fw=new FileWriter(file);
        String textToAppend="";
        for(Task task:tasks){
            textToAppend+=task.getTaskStorageString()+"\n";
        }

        fw.write(textToAppend);
        fw.close();
    }
}