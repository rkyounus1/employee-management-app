package com.espot.employeemanagementapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
@GetMapping("/")
public String getEmployee(){
    String emp = "EmployeeMethod";
        return emp;
    }
}
