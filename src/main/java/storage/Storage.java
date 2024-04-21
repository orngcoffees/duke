package storage;

import tasklist.*;

import java.io.File;
import java.io.FileOutputStream;
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
        assert filePath!=null : "Filepath cannot be empty.";
        file= new File(filePath);
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
    public static void save(String filePath, ArrayList<Task> taskList) {
        try {
            if (!file.exists()) {
                File f = new File(filePath);
                if (!f.exists()) {
                    f.getParentFile().mkdirs();
                }
            }
            FileOutputStream writer = new FileOutputStream(filePath);

            for (Task task : taskList) {
                writer.write((task.getTaskStorageString() + '\n').getBytes());
            }
            writer.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}