package exercises;

import db.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class Exercise02 {

//    Напишете програма която чете диапазон на заплатата(from-to) от конзолата и изкарва информация за служители които
//    отговарят на зададените критерии. Използвайте prepared statement и дайте възможност на потребителя да повтори операцията,
//    а не да излиза от програмата след първото търсене. Прихванете възможните exception-и и затворете всички ресурси в finally блок.

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter salary in range (example: 1500-2000) or enter 0 for exit:");
            String salaryRange = scanner.nextLine();

            if (salaryRange.equals("0")) {
                break;
            }

            Connection dbConnection = DBManager.getInstance().getConnection();
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;

            String query = "SELECT CONCAT(first_name, ' ', last_name) AS 'employee_name', salary, job_id " +
                    "FROM employees WHERE salary BETWEEN ? AND ? ORDER BY salary;";
            try {
                 preparedStatement = dbConnection.prepareStatement(query);
                preparedStatement.setString(1, salaryRange.split("-")[0]);
                preparedStatement.setString(2, salaryRange.split("-")[1]);
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("All employees and their salaries based on input criteria:");
                    while (resultSet.next()) {
                        String firstName = resultSet.getString("employee_name");
                        double salary = resultSet.getDouble("salary");
                        String jobId = resultSet.getString("job_id");
                        System.out.printf("%15s %15.2f %15s %n", firstName, salary, jobId);
                    }
                    System.out.println("---------------------------------------------------------------");
                } else {
                    System.out.println("No employees based on input criteria!");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    dbConnection.close();
                    Objects.requireNonNull(preparedStatement).close();
                    Objects.requireNonNull(resultSet).close();
                } catch (SQLException e) {
                    System.out.println("Something went wrong with closing the resources.");
                }
            }
        }


    }

}
