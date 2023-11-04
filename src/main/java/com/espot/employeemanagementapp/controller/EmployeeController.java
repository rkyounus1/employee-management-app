package com.espot.employeemanagementapp.controller;

import com.espot.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.espot.employeemanagementapp.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
@GetMapping("/")
public List<Employee> getEmployee(){
       List<Employee> list = employeeRepository.findAll();
        return list;
    }

}
