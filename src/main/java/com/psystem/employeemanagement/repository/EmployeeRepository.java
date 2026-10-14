package com.psystem.employeemanagement.repository;

import com.psystem.employeemanagement.entity.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByOrderByIdDesc();
}
