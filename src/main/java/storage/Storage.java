package storage;

import tasklist.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


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