package com.psystem.employeemanagement.service;

import com.psystem.employeemanagement.dto.EmployeeRequest;
import com.psystem.employeemanagement.dto.EmployeeResponse;
import com.psystem.employeemanagement.entity.Employee;
import com.psystem.employeemanagement.repository.EmployeeRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    public List<EmployeeResponse> getEmployees() {
        return employeeRepository.findAllByOrderByIdDesc().stream()
                .map(this::toResponse)
                .toList();
    }

    @Transactional
    public EmployeeResponse saveEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName().trim());
        employee.setEmail(request.getEmail().trim());
        employee.setPhone(trimToNull(request.getPhone()));
        employee.setDepartment(trimToNull(request.getDepartment()));
        employee.setRole(trimToNull(request.getRole()));

        return toResponse(employeeRepository.save(employee));
    }

    private EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .department(employee.getDepartment())
                .role(employee.getRole())
                .build();
    }

    private String trimToNull(String value) {
        if (value == null) {
            return null;
        }
        String trimmed = value.trim();
        return trimmed.isEmpty() ? null : trimmed;
    }
}
