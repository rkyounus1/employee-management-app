package com.espot.employeemanagementapp.controller;

import com.espot.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.espot.employeemanagementapp.entity.Employee;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

@GetMapping("/")
public List<Employee> getEmployee(){
       List<Employee> list = employeeRepository.findAll();
        return list;
    }
@GetMapping("/{id}")
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
public String deleteEmployee(@PathVariable("id") Long empId) {
            employeeRepository.deleteById(empId);
            return "Employee with ID " + empId + " has been deleted.";

    }

}
