package prog.model;

import prog.view.windows.ErrorWindow;

import java.sql.*;

public class DBConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/java_learning";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "qw20011993QW";

    private Connection connector;

    public void openConnection() {
        try {
            connector = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            new ErrorWindow().launchWin("Error in data base connection",
                    "Check your connection with data base");
        }
    }
    public Connection getConnector() { return connector; }
}