import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;

public class Storage {

    private static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath); // create a File for the given file path
        Scanner s = new Scanner(f); // create a Scanner using the File as the source
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }
    }
    
    private static void writeToFile(String filePath, List<Task> taskList) throws IOException {
        System.out.println(Duke.taskList);
        FileWriter fw = new FileWriter(filePath);
        for (Task arr : taskList) {
            fw.write(arr.toString() + System.lineSeparator());
        }
        fw.close();
    }

    public static void main(String[] args) {
        String homeDir = System.getProperty("user.home");
        File targetDir = new File(homeDir, "/Documents/Duke/data/");
        File storageFile = new File(targetDir, "duke.txt");

        if (!targetDir.exists()) {
            targetDir.mkdirs(); // creates directory and any missing parent directories
        }

        try {
            writeToFile(String.valueOf(storageFile), Duke.taskList);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    static void main() {
        Storage.main(null);
    }
    
}
