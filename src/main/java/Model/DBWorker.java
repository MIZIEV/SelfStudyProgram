package Model;

import View.windows.ErrorWindow;

import java.sql.*;
import java.util.ArrayList;

public class DBWorker {

    private final DBConnector connector;

    private static final byte INDEX_COLUMN = 2;
    private static final byte THEME_COLUMN = 3;
    private static final byte QUESTION_COLUMN = 4;
    private static final byte ANSWER_COLUMN = 5;

    private static final String query = "SELECT * from java_learning.javalearning";

    private final ArrayList<InfoFromDB> bufferList = new ArrayList<>();

    private final ArrayList<InfoFromDB> coreList = new ArrayList<>();
    private final ArrayList<InfoFromDB> collectionList = new ArrayList<>();
    private final ArrayList<InfoFromDB> java8List = new ArrayList<>();
    private final ArrayList<InfoFromDB> IOList = new ArrayList<>();
    private final ArrayList<InfoFromDB> serializationList = new ArrayList<>();
    private final ArrayList<InfoFromDB> MTList = new ArrayList<>();
    private final ArrayList<InfoFromDB> dataBaseList = new ArrayList<>();
    private final ArrayList<InfoFromDB> SQLList = new ArrayList<>();
    private final ArrayList<InfoFromDB> JDBCList = new ArrayList<>();
    private final ArrayList<InfoFromDB> XMLList = new ArrayList<>();
    private final ArrayList<InfoFromDB> HTMLList = new ArrayList<>();
    private final ArrayList<InfoFromDB> CSSList = new ArrayList<>();

    public DBWorker(DBConnector connector) {
        this.connector = connector;
        connector.openConnection();
    }

    public void distributeLists() {
        ArrayList<InfoFromDB> allQAList = new ArrayList<>();
        InfoFromDB infoFromDB;

        try (Statement statement = connector.getConnector().createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                infoFromDB = new InfoFromDB(
                        resultSet.getInt(INDEX_COLUMN),
                        resultSet.getString(THEME_COLUMN),
                        resultSet.getString(QUESTION_COLUMN),
                        resultSet.getString(ANSWER_COLUMN),
                        0
                );

                allQAList.add(infoFromDB);
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
                    case "DataBase":
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
            new ErrorWindow().launchWin("Error in distributor","Check distributor");
        }
    }

    public ArrayList<InfoFromDB> getBufferList() { return bufferList; }

    public ArrayList<InfoFromDB> getCoreList() { return coreList; }

    public ArrayList<InfoFromDB> getCollectionList() { return collectionList; }

    public ArrayList<InfoFromDB> getJava8List() { return java8List; }

    public ArrayList<InfoFromDB> getIOList() { return IOList; }

    public ArrayList<InfoFromDB> getSerializationList() { return serializationList; }

    public ArrayList<InfoFromDB> getMTList() { return MTList; }

    public ArrayList<InfoFromDB> getDataBaseList() { return dataBaseList; }

    public ArrayList<InfoFromDB> getSQLList() { return SQLList; }

    public ArrayList<InfoFromDB> getJDBCList() { return JDBCList; }

    public ArrayList<InfoFromDB> getXMLList() { return XMLList; }

    public ArrayList<InfoFromDB> getHTMLList() { return HTMLList; }

    public ArrayList<InfoFromDB> getCSSList() { return CSSList; }
}