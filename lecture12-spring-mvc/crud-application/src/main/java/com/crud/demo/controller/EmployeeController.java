package com.crud.demo.controller;

import com.crud.demo.model.Employee;
import com.crud.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public String displayHomePage(Model model) {
        model.addAttribute("allEmployees", employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/edit/employee/{id}")
    public String displayEditForm(@PathVariable("id") Long id, Model model) {
        Employee employeeById = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employeeById);
        return "edit_employee";
    }

    @PostMapping("/edit_employee")
    public String editEmployee(Employee employee) {
        this.employeeService.editEmployee(employee);
        return "redirect:/employees";
    }
}
