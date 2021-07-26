package prog.model;

import org.json.JSONObject;
import prog.view.windows.ErrorWindow;

import java.io.*;
import java.util.ArrayList;

/**
 * class description:
 * this class needed to converting information to JSON format with method - convertToJSON(ArrayList<InfoFromDB> list);
 * also converting information from JSON with method - convertFromJSON(File fileWithJSON);
 */
public class JSONWorker {

    private final ResultCounter result;
    private double totalResult;

    public JSONWorker(ResultCounter result) {
        this.result = result;
    }

    public JSONObject convertToJSON(ArrayList<InfoFromDB> list) {

        JSONObject obj = new JSONObject();
        obj.put("list", list);

        return obj;
    }

    public ArrayList<InfoFromDB> convertFromJSON(File fileWithJSON) {
        InfoFromDB dataFromJSON;
        ArrayList<InfoFromDB> bufferList = new ArrayList<>();
        bufferList.clear();
        int c;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            FileReader reader = new FileReader(fileWithJSON);

            while ((c = reader.read()) != -1) {
                stringBuffer.append((char) c);
            }

            if (!stringBuffer.toString().isEmpty()) {

                String string = stringBuffer.toString();
                JSONObject obj = new JSONObject(string);
                int counter = 0;
                int jsonSize = obj.getJSONArray("list").length();

                while (counter <= jsonSize - 1) {
                    dataFromJSON = new InfoFromDB(
                            obj.getJSONArray("list").getJSONObject(counter).getInt("index"),
                            obj.getJSONArray("list").getJSONObject(counter).getString("theme"),
                            obj.getJSONArray("list").getJSONObject(counter).getString("question"),
                            obj.getJSONArray("list").getJSONObject(counter).getString("answer"),
                            obj.getJSONArray("list").getJSONObject(counter).getInt("yesNo"));

                    bufferList.add(dataFromJSON);
                    counter++;
                }
            }
            reader.close();
            totalResult = result.countingFromFile(bufferList);
        } catch (IOException e) {
            ErrorWindow errorWindow = new ErrorWindow();
            errorWindow.launchWin("Error in JSON worker","cheek this worker");
        }
        return bufferList;
    }
    public double getTotalResult() {
        return totalResult;
    }
}