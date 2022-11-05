package homework;

import db.DBManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String SELECT_NAME_EMAIL_HIRE_DATE_JOB_ID_SALARY_FROM_EMPLOYEES
            = "SELECT first_name, last_name, email, hire_date, job_id, salary FROM employees AS e ";

    public static List<Employee> searchByFirstName(String firstName) {
        Connection connection = DBManager.getInstance().getConnection();
        List<Employee> foundEmployeesByFirstName = new ArrayList<>();

        try {
            String query = SELECT_NAME_EMAIL_HIRE_DATE_JOB_ID_SALARY_FROM_EMPLOYEES + "WHERE first_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = employeeFromResultSet(resultSet);
                foundEmployeesByFirstName.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when searching employee by first name.");
        }

        return foundEmployeesByFirstName;
    }

    public static List<Employee> searchByLastName(String lastName) {
        Connection connection = DBManager.getInstance().getConnection();
        List<Employee> foundEmployeesByLastName = new ArrayList<>();

        try {
            String query = SELECT_NAME_EMAIL_HIRE_DATE_JOB_ID_SALARY_FROM_EMPLOYEES + "WHERE last_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = employeeFromResultSet(resultSet);
                foundEmployeesByLastName.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when searching employee by first name.");
        }

        return foundEmployeesByLastName;
    }

    public static List<Employee> searchByDepartmentName(String departmentName) {
        Connection connection = DBManager.getInstance().getConnection();
        List<Employee> foundEmployeesByDepartmentName = new ArrayList<>();

        try {
            String query = SELECT_NAME_EMAIL_HIRE_DATE_JOB_ID_SALARY_FROM_EMPLOYEES +
                    "JOIN departments AS d ON e.department_id = d.department_id WHERE d.department_name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, departmentName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = employeeFromResultSet(resultSet);
                foundEmployeesByDepartmentName.add(employee);
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when searching employee by first name.");
        }

        return foundEmployeesByDepartmentName;
    }

    public static boolean add(Employee employee) {
        Connection connection = DBManager.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(employee_id) AS last_id FROM employees");
            int id = 0;
            while (resultSet.next()) {
                id = resultSet.getInt("last_id");
            }

            String query = "INSERT INTO employees " +
                    "(employee_id, first_name, last_name, email, hire_date, job_id, salary) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id + 1);
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, String.valueOf(employee.getHireDate()));
            preparedStatement.setString(6, employee.getJobId());
            preparedStatement.setDouble(7, employee.getSalary());
            preparedStatement.executeUpdate();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Employee employeeFromResultSet(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        LocalDate hireDate = resultSet.getDate("hire_date").toLocalDate();
        String jobId = resultSet.getString("job_id");
        double salary = resultSet.getDouble("salary");
        return new Employee(firstName, lastName, email, hireDate, jobId, salary);
    }
    
}
