import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private Connection connection;

    public DBManager(String dbDriver, String dbHost, String dbPort, String dbName, String dbUser, String dbPassword) {
        try {
            Class.forName(dbDriver);
            this.connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName, dbUser, dbPassword);
        } catch (SQLException e) {
            System.out.println("Error creating connection - " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("You have to install or add dependency of the driver that we are going to use.");
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}