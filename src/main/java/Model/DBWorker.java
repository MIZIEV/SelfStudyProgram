package Model;

import java.sql.*;
import java.util.ArrayList;

public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/java_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "qw20011993QW";
    private static final String query = "SELECT * from java_learning.javalearning";

    private static final byte INDEX_COLUMN = 2;
    private static final byte THEME_COLUMN = 3;
    private static final byte QUESTION_COLUMN = 4;
    private static final byte ANSWER_COLUMN = 5;

    private Connection connection;

    private final ArrayList<StringFromDB> bufferList = new ArrayList<>();

    private final ArrayList<StringFromDB> coreList = new ArrayList<>();
    private final ArrayList<StringFromDB> collectionList = new ArrayList<>();
    private final ArrayList<StringFromDB> java8List = new ArrayList<>();
    private final ArrayList<StringFromDB> IOList = new ArrayList<>();
    private final ArrayList<StringFromDB> serializationList = new ArrayList<>();
    private final ArrayList<StringFromDB> MTList = new ArrayList<>();
    private final ArrayList<StringFromDB> dataBaseList = new ArrayList<>();
    private final ArrayList<StringFromDB> SQLList = new ArrayList<>();
    private final ArrayList<StringFromDB> JDBCList = new ArrayList<>();
    private final ArrayList<StringFromDB> XMLList = new ArrayList<>();
    private final ArrayList<StringFromDB> HTMLList = new ArrayList<>();
    private final ArrayList<StringFromDB> CSSList = new ArrayList<>();

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
                        resultSet.getInt(INDEX_COLUMN),
                        resultSet.getString(THEME_COLUMN),
                        resultSet.getString(QUESTION_COLUMN),
                        resultSet.getString(ANSWER_COLUMN),
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
                    case "Model":
                        dataBaseList.add(allQAList.get(counter));
                        break;
                    case "SQL":
                        SQLList.add(allQAList.get(counter));
                        break;
                    case "JDBC":
                        JDBCList.add(allQAList.get(counter));
                        break;
                    case "XML":
                        XMLList.add(allQAList.get(counter));
                        break;
                    case "HTML":
                        HTMLList.add(allQAList.get(counter));
                        break;
                    case "CSS":
                        CSSList.add(allQAList.get(counter));
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

    public ArrayList<StringFromDB> getDataBaseList() { return dataBaseList; }

    public ArrayList<StringFromDB> getSQLList() { return SQLList; }

    public ArrayList<StringFromDB> getJDBCList() { return JDBCList; }

    public ArrayList<StringFromDB> getXMLList() { return XMLList; }

    public ArrayList<StringFromDB> getHTMLList() { return HTMLList; }

    public ArrayList<StringFromDB> getCSSList() { return CSSList; }
}