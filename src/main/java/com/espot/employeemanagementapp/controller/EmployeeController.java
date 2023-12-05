package com.espot.employeemanagementapp.controller;

import com.espot.employeemanagementapp.dto.EmployeeDepartmentDTO;
import com.espot.employeemanagementapp.entity.Department;
import com.espot.employeemanagementapp.repository.DepartmentRepository;
import com.espot.employeemanagementapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.espot.employeemanagementapp.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employees/")
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
public class EmployeeController  {
    @Autowired
    EmployeeRepository employeeRepository;

//    @Autowired
//    DepartmentRepository departmentRepository;
//    @GetMapping("")
//    public List<EmployeeDepartmentDTO> getEmployeeDetails() {
//        List<EmployeeDepartmentDTO> employeeDepartmentDTOList = new ArrayList<>();
//
//        List<Employee> employees = employeeRepository.findAll();
//
//        for (Employee employee : employees) {
//            EmployeeDepartmentDTO dto = new EmployeeDepartmentDTO();
//            dto.setId(employee.getId());
//            dto.setFirstName(employee.getFirstName());
//            dto.setLastName(employee.getLastName());
//            dto.setEmailId(employee.getEmailId());
//
//            Department department = employee.getDepartment();
//            if (department != null) {
//                dto.setDepartmentName(department.getDepartmentName());
//                dto.setFromDate(department.getFromDate());
//                dto.setToDate(department.getToDate());
//                dto.setAge(department.getAge());
//                dto.setSalary(department.getSalary());
//                dto.setMobileNo(department.getMobileNo());
//            }
//
//            employeeDepartmentDTOList.add(dto);
//        }
//
//        return employeeDepartmentDTOList;
//    }

@GetMapping("{id}")
public Optional<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
        Optional<Employee> empId = employeeRepository.findById(employeeId);
        return empId;
    }

@PostMapping("")
public String createEmp(@RequestBody Employee employee){
//    Department department = employee.getDepartment();
//    if (department != null) {
//        departmentRepository.save(department);
//    }
    employeeRepository.save(employee);
    return "success";
    }

@DeleteMapping("{id}")
public String deleteEmployee(@PathVariable("id") Long id) {
            employeeRepository.deleteById(id);
            return "Employee with ID " + id + " has been deleted.";
    }

@PutMapping("{id}")
public String updateEmployee(@PathVariable("id") Long id ,@RequestBody Employee updatedemployee){
    Optional<Employee> existingEmployee = employeeRepository.findById(id);

    if(existingEmployee.isPresent()){
    Employee employee = existingEmployee.get();
    employee.setFirstName(updatedemployee.getFirstName());
    employee.setLastName(updatedemployee.getLastName());
    employee.setEmailId(updatedemployee.getEmailId());

    employeeRepository.save(employee);

    }

return "Updated Employee";
}

    @PatchMapping("{id}")
    public String patchUpdateEmployee(@PathVariable("id") Long id, @RequestBody Employee updatedEmployee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {
            Employee employee = existingEmployee.get();

            if (updatedEmployee.getFirstName() != null) {
                employee.setFirstName(updatedEmployee.getFirstName());
            }
            if (updatedEmployee.getLastName() != null) {
                employee.setLastName(updatedEmployee.getLastName());
            }
            if (updatedEmployee.getEmailId() != null) {
                employee.setEmailId(updatedEmployee.getEmailId());
            }

            employeeRepository.save(employee);
            return "Updated Employee";
        } else {
            return "Employee not found";
        }
    }

}
