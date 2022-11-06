package homework;

import homework.model.Employee;
import homework.model.EmployeeDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Application {

    public void start() {
        while (true) {
            Console.show();
            int userChoice = Console.readUserInput();
            if (userChoice == 7) {
                Console.showExitMessage();
                return;
            }

            switch (userChoice) {
                case 1: // Search by first name
                    Console.showMessageSameLine("Enter first name that will be used for search criteria: ");
                    String firstName = Console.readTextFromConsole();
                    searchByFirstName(firstName);
                    break;
                case 2: // Search by last name
                    Console.showMessageSameLine("Enter last name that will be used for search criteria: ");
                    String lastName = Console.readTextFromConsole();
                    searchByLastName(lastName);
                    break;
                case 3: // Search by department name
                    Console.showMessageSameLine("Enter department name that will be used for search criteria: ");
                    String departmentName = Console.readTextFromConsole();
                    searchByDepartmentName(departmentName);
                    break;
                case 4:
                    Console.showMessageSameLine("Enter first name,last name,department name " +
                            "(example: fName,lName,dName) that will be used for search criteria: ");
                    String[] data = Console.readTextFromConsole().split(",");
                    searchByFirstLastDepartmentName(data);
                    break;
                case 5:
                    Console.showMessageNewLine("Please enter following data in one line separated by ',' (comma).");
                    Console.showMessageNewLine("first name,last name,email,date (YYYY-mm-dd),job id (AC_MGR),salary");
                    String[] employeeData = Console.readTextFromConsole().split(",");
                    addEmployee(employeeData);
                    break;
                case 6:
                    Console.showMessageSameLine("Please enter employee id that you want to delete: ");
                    long id = Long.parseLong(Console.readTextFromConsole());
                    deleteEmployeeById(id);
                    break;
            }
            Console.pressEnterToContinue();
        }
    }

    private void searchByFirstName(String firstName) {
        List<Employee> employees;
        try {
            employees = EmployeeDAO.searchByFirstName(firstName);
            Console.printResultOnConsole(employees);
        } catch (SQLException e) {
            Console.showSomethingWentWrongMessage();
        }
    }

    private void searchByLastName(String lastName) {
        List<Employee> employees;
        try {
            employees = EmployeeDAO.searchByLastName(lastName);
            Console.printResultOnConsole(employees);
        } catch (SQLException e) {
            Console.showSomethingWentWrongMessage();
        }
    }

    private void searchByDepartmentName(String departmentName) {
        List<Employee> employees = EmployeeDAO.searchByDepartmentName(departmentName);
        Console.printResultOnConsole(employees);
    }

    private void searchByFirstLastDepartmentName(String[] data) {
        try {
            List<Employee> employees = EmployeeDAO.searchByFirstNameLastNameDepartmentName(data[0], data[1], data[2]);
            Console.printResultOnConsole(employees);
        } catch (SQLException e) {
            Console.showSomethingWentWrongMessage();
        }
    }

    private void addEmployee(String[] employeeData) {
        Employee employee;
        try {
            employee = new Employee(employeeData[0], employeeData[1],
                    employeeData[2], LocalDate.parse(employeeData[3]),
                    employeeData[4], Double.parseDouble(employeeData[5]));
        } catch (Exception e) {
            Console.showMessageNewLine("Invalid data entered! Please review your input and try again.");
            return;
        }


        try {
            EmployeeDAO.add(employee);
            Console.showSuccessMessage("Successfully added: " + employee);
        } catch (SQLException ex) {
            Console.showSomethingWentWrongMessage();
        }
    }

    private void deleteEmployeeById(long id) {
        try {
            int affectedRows = EmployeeDAO.deleteEmployeeById(id);
            if (affectedRows > 0) {
                Console.showSuccessMessage("Successfully deleted employee with id: " + id);
            } else {
                Console.showMessageNewLine("Employee with id: " + id + " does not exist!");
            }
        } catch (SQLException e) {
            Console.showMessageNewLine("Something went wrong when delete user by id: " + id);
        }
    }
}
