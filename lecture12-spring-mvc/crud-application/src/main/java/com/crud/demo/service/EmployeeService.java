package com.crud.demo.service;

import com.crud.demo.model.Employee;
import com.crud.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    public void editEmployee(Employee employee) {
        Employee foundEmployee = this.employeeRepository.findById(employee.getId()).get();
        foundEmployee.setFirstName(employee.getFirstName());
        foundEmployee.setLastName(employee.getLastName());
        foundEmployee.setEmail(employee.getEmail());
        foundEmployee.setSalary(employee.getSalary());
        this.employeeRepository.save(foundEmployee);
    }
}
