package exercises;

//Напишете програма която извежда на конзолата всички служители и техните заплати от hr схемата;
//Всички ресурси(connections, statements и ResultSets) трябва да бъдат затворени в finally блок.

import db.DBManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class Exercise01 {

    public static void main(String[] args) {

        Connection dbConnection = DBManager.getInstance().getConnection();
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = dbConnection.createStatement();
            resultSet = statement.executeQuery("SELECT first_name, last_name, salary FROM employees");

            System.out.println("All employees and their salaries:");
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                double salary = resultSet.getDouble("salary");
                System.out.printf("%10s %10s %10.2f %n", firstName, lastName, salary);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dbConnection.close();
                Objects.requireNonNull(statement).close();
                Objects.requireNonNull(resultSet).close();
            } catch (SQLException e) {
                System.out.println("Something went wrong with closing the resources.");
            }
        }

    }
}
