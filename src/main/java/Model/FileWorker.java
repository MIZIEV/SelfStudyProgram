package Model;

import java.io.File;
import java.util.ArrayList;

/**
 * Class description:
 * This class is needed to getting all .txt files with saved information about last learning.
 *
 * Methods description:
 * void searchFiles(); - this method search files in /resources/SavedFiles and then it put file's name to ArrayList;
 * File getFile(String fileName); - this method takes String with file name and return file with this name;
 * void removeFile(String fileName); - this method takes String with file name and remove this file.
 */
public class FileWorker {

    private final ArrayList<String> filesName = new ArrayList<>();

    private final static String SAVING_FILE_PATH = "C:\\IT\\Java\\Self study program\\src\\main\\Resources\\SavedFiles\\";

    public void searchFiles() {
        File searchFile = new File(SAVING_FILE_PATH);
        String savingFiles[] = searchFile.list();

        filesName.clear();
        for (int x = 0; x < savingFiles.length; x++) {
            filesName.add(savingFiles[x]);
        }
    }

    public File getFile(String fileName) {
        File savedFile = new File(SAVING_FILE_PATH + fileName);
        return savedFile;
    }

    public void removeFile(String fileName) {
        File fileToRemove = new File(SAVING_FILE_PATH + fileName);
        fileToRemove.delete();
    }

    public ArrayList<String> getFilesName() { return filesName; }
}