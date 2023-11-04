package com.espot.employeemanagementapp.controller;

import com.espot.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.espot.employeemanagementapp.entity.Employee;

import java.util.List;
import java.util.Optional;

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
@GetMapping("/employee/{id}")
public Optional<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
        Optional<Employee> empId = employeeRepository.findById(employeeId);
        return empId;
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
