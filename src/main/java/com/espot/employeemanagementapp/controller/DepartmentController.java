package com.espot.employeemanagementapp.controller;

import com.espot.employeemanagementapp.entity.Department;
import com.espot.employeemanagementapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/")
    public List<Department> getDepartment(){
        List<Department> list = departmentRepository.findAll();
        return list;
    }

    @PostMapping("/")
    public String addDepartment(@RequestBody Department department){
        departmentRepository.save(department);
        return  "Department Added Successfully";
    }
}

