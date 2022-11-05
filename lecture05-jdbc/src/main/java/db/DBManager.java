package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    public static DBManager instance;
    private Connection connection;
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "hr";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "root";

    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME, DB_USER, DB_PASS);
        } catch (SQLException e) {
            System.out.println("Error creating connection - " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("You have to install or add dependency of the driver that we are going to use.");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
