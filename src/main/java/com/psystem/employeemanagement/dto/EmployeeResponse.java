package com.psystem.employeemanagement.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeResponse {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String role;
}
