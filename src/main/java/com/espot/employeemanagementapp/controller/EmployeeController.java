package com.espot.employeemanagementapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @PostMapping("/emp")
    public <emp> String createEmp(@RequestBody emp a){
         String empName="name";
         return empName;
    }

    @GetMapping("/")
public String getEmployee(){
    String emp = "EmployeeMethod ";
        return emp;
    }
}
