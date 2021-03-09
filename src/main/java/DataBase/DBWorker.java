package DataBase;

import java.sql.*;
import java.util.*;

public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost:3306/java_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "qw20011993QW";
    private static final String query = "SELECT * from java_learning.javalearning";

    private static final int INDEXCOLUMM = 2;
    private static final int QUESTIONCOLUMM = 3;
    private static final int ANSWERCOLUMM = 4;
    private StringFromDB stringFromDB;

    private Connection connection;


    private ArrayList<StringFromDB> QAList = new ArrayList<>();

    public DBWorker() {
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
                        resultSet.getString(QUESTIONCOLUMM),
                        resultSet.getString(ANSWERCOLUMM),
                        false
                );

                QAList.add(stringFromDB);
            }

        } catch (SQLException throwables) {
            System.out.println("error int worker2");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public ArrayList<StringFromDB> getQAList() {
        return QAList;
    }
}
