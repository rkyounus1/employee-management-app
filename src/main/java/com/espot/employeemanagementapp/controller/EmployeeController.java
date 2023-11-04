package com.espot.employeemanagementapp.controller;

import com.espot.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/")
    public String createEmp(@RequestBody Employee employee){
    employeeRepository.save(employee);
    return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
            employeeRepository.deleteById(id);
            return "Employee with ID " + id + " has been deleted.";

    }

}
