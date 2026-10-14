package com.psystem.employeemanagement.config;

import com.psystem.employeemanagement.entity.Employee;
import com.psystem.employeemanagement.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataInitializer(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        if (employeeRepository.count() > 0) {
            return;
        }

        employeeRepository.save(employee("Ada Lovelace", "ada.lovelace@company.com", "555-0101", "Engineering", "Software Engineer"));
        employeeRepository.save(employee("Grace Hopper", "grace.hopper@company.com", "555-0102", "Engineering", "Tech Lead"));
        employeeRepository.save(employee("Alan Turing", "alan.turing@company.com", "555-0103", "Research", "Data Analyst"));
    }

    private Employee employee(String name, String email, String phone, String department, String role) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setDepartment(department);
        employee.setRole(role);
        return employee;
    }
}
