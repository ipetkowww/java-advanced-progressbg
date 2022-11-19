import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {

    @Autowired
    private DBManager dbManager;

    public List<Employee> findAll() throws SQLException {
        Connection connection = dbManager.getConnection();
        List<Employee> employees = new ArrayList<>();

        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT first_name, last_name, email, hire_date, job_id, salary FROM employees");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Employee employee = employeeFromResultSet(resultSet);
            employees.add(employee);
        }
        return employees;
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