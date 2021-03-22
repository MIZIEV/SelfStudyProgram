package DataBase;

import java.sql.*;
import java.util.*;

public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/java_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "qw20011993QW";
    private static final String query = "SELECT * from java_learning.javalearning";

    private static final byte INDEXCOLUMM = 2;
    private static final byte THEMECOLUMM = 3;
    private static final byte QUESTIONCOLUMM = 4;
    private static final byte ANSWERCOLUMM = 5;

    private Connection connection;

    private final ArrayList<StringFromDB> bufferList = new ArrayList<>();

    private final ArrayList<StringFromDB> coreList = new ArrayList<>();
    private final ArrayList<StringFromDB> collectionList = new ArrayList<>();
    private final ArrayList<StringFromDB> java8List = new ArrayList<>();
    private final ArrayList<StringFromDB> IOList = new ArrayList<>();
    private final ArrayList<StringFromDB> serializationList = new ArrayList<>();
    private final ArrayList<StringFromDB> MTList = new ArrayList<>();

    public DBWorker() {

        ArrayList<StringFromDB> allQAList = new ArrayList<>();
        StringFromDB stringFromDB;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            System.out.println("error in worker");
        }

        try (Statement statement = this.getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                stringFromDB = new StringFromDB(
                        resultSet.getInt(INDEXCOLUMM),
                        resultSet.getString(THEMECOLUMM),
                        resultSet.getString(QUESTIONCOLUMM),
                        resultSet.getString(ANSWERCOLUMM),
                        false
                );

                allQAList.add(stringFromDB);
            }

            int counter = 0;
            while (allQAList.size() > counter) {

                switch (allQAList.get(counter).getTheme()) {
                    case "Core":
                        coreList.add(allQAList.get(counter));
                        break;
                    case "Collections":
                        collectionList.add(allQAList.get(counter));
                        break;
                    case "Java 8":
                        java8List.add(allQAList.get(counter));
                        break;
                    case "Java IO/NIO":
                        IOList.add(allQAList.get(counter));
                        break;
                    case "Serialization":
                        serializationList.add(allQAList.get(counter));
                        break;
                    case "Multithreading ":
                        MTList.add(allQAList.get(counter));
                        break;
                }
                counter++;
            }
        } catch (SQLException throwables) {
            System.out.println("error int worker2");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<StringFromDB> getBufferList() { return bufferList; }

    public ArrayList<StringFromDB> getCoreList() { return coreList; }

    public ArrayList<StringFromDB> getCollectionList() { return collectionList; }

    public ArrayList<StringFromDB> getJava8List() { return java8List; }

    public ArrayList<StringFromDB> getIOList() { return IOList; }

    public ArrayList<StringFromDB> getSerializationList() { return serializationList; }

    public ArrayList<StringFromDB> getMTList() { return MTList; }
}