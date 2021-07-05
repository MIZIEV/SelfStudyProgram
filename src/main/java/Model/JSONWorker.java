package Model;

import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class JSONWorker {

    private final CountingResult result;

    public JSONWorker(CountingResult result) {
        this.result = result;
    }

    public void convertToJSON(ArrayList<InfoFromDB> list) {
        GregorianCalendar calendar = new GregorianCalendar();
        String nowTime = calendar.getTime().toString();
        String splitString[] = nowTime.split("\\s|\\:");
        double resultPercent = result.counting() * 100;
        String fileName = splitString[0] + " " + splitString[1] +
                " Day " + splitString[2] +
                " Time " + splitString[3] + " " + splitString[4] +
                " Result " + (int) resultPercent;

        JSONObject obj = new JSONObject();
        obj.put("list", list);
        System.out.println(fileName);
        String bufferString = obj.toString();
        byte buf[] = bufferString.getBytes();
        try {
            File saveFile = new File("C:\\IT\\Java\\Self study program\\src\\main\\Resources\\" + fileName + ".txt");
            saveFile.createNewFile();
            FileOutputStream writer = new FileOutputStream(saveFile);
            for (int i = 0; i < buf.length; i++) {
                writer.write(buf[i]);
            }
            System.out.println("done !!!");
        } catch (IOException e) {
            //  e.printStackTrace();
            System.out.println("error");
        }
    }

    public ArrayList<InfoFromDB>  convertFromJSON() {
        InfoFromDB infoFromJSON;
        ArrayList<InfoFromDB> bufferList = new ArrayList<>();
        int c;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            FileReader reader =
                    new FileReader("C:\\IT\\Java\\Self study program\\src\\main\\Resources\\Mon Jul Day 05 Time 20 37 Result 33.txt");
            System.out.println("string buf");
            while ((c = reader.read()) != -1) {
                stringBuffer.append((char) c);
            }
            System.out.println(stringBuffer);

            if (!stringBuffer.toString().isEmpty()) {

                String string = stringBuffer.toString();
                JSONObject obj = new JSONObject(string);
                int counter = 0;
                int jsonSize = obj.getJSONArray("list").length();

                while (counter <= jsonSize - 1) {
                    infoFromJSON = new InfoFromDB(
                            obj.getJSONArray("list").getJSONObject(counter).getInt("index"),
                            obj.getJSONArray("list").getJSONObject(counter).getString("theme"),
                            obj.getJSONArray("list").getJSONObject(counter).getString("question"),
                            obj.getJSONArray("list").getJSONObject(counter).getString("answer"),
                            obj.getJSONArray("list").getJSONObject(counter).getBoolean("yesNo"));

                    bufferList.add(infoFromJSON);
                    counter++;
                }
            }
            System.out.println("list");
            System.out.println(bufferList);
            System.out.println("done");
        } catch (IOException e) {
            System.out.println("error");
        }
         return bufferList;
    }
}
