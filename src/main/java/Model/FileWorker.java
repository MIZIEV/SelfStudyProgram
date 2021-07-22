package Model;

import View.windows.SaveWindow;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;

/**
 * Class description:
 * This class is needed to getting all .txt files with saved information about last learning.
 * <p>
 * Methods description:
 * void searchFiles(); - this method search files in /resources/SavedFiles and then it put file's name to ArrayList;
 * File getFile(String fileName); - this method takes String with file name and return file with this name;
 * void removeFile(String fileName); - this method takes String with file name and remove this file;
 * void putInfoToFile(ArrayList<InfoFromDB> list, ResultCounter result, JSONObject jsonObject); - this method
 * takes JSON object and put they to file, also it takes ArrayList for taked learning theme and result for
 * creating file name.
 */
public class FileWorker {

    private final ArrayList<String> filesName = new ArrayList<>();

    private final static String SAVING_FILE_PATH = "C:\\IT\\Java\\Self study program\\src\\main\\Resources\\SavedFiles\\";

    public final void searchFiles() {
        File searchFile = new File(SAVING_FILE_PATH);
        String savingFiles[] = searchFile.list();

        filesName.clear();
        for (int x = 0; x < savingFiles.length; x++) {
            filesName.add(savingFiles[x]);
        }
    }

    public final File getFile(String fileName) {
        File savedFile = new File(SAVING_FILE_PATH + fileName);
        return savedFile;
    }

    public final void removeFile(String fileName) {
        File fileToRemove = new File(SAVING_FILE_PATH + fileName);
        fileToRemove.delete();
    }

    public void putInfoToFile(ArrayList<InfoFromDB> list, ResultCounter result, JSONObject jsonObject) {
        GregorianCalendar calendar = new GregorianCalendar();
        String nowTime = calendar.getTime().toString();

        HashSet<String> selectedTheme = new HashSet<>();
        for (InfoFromDB element : list) {
            if(element.getTheme().equals("Java IO/NIO")) selectedTheme.add("Java IO&NIO"); //todo this is shit???
            else selectedTheme.add(element.getTheme());
        }

        String splitString[] = nowTime.split("\\s|\\:");
        double resultPercent = result.countingTotalResult() * 100;
        String fileName = splitString[1] + " " + splitString[2] +
                " " + splitString[3] + " " + splitString[4] +
                " Theme" + selectedTheme +
                " Result " + (int) resultPercent + "%";
        String bufferString = jsonObject.toString();
        byte buf[] = bufferString.getBytes();
        try {
            File saveFile = new File(SAVING_FILE_PATH + fileName + ".txt");
            saveFile.createNewFile();
            FileOutputStream writer = new FileOutputStream(saveFile);
            for (int i = 0; i < buf.length; i++) {
                writer.write(buf[i]);
            }
            SaveWindow.initWindow(true);
        } catch (IOException e) {
            SaveWindow.initWindow(false);
            e.printStackTrace();
        }
    }

    public ArrayList<String> getFilesName() {
        return filesName;
    }
}