import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public List<Employee> getAllEmployees() {
        try {
            return employeeDAO.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
