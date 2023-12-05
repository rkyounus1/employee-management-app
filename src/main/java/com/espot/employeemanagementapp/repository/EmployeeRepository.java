package com.espot.employeemanagementapp.repository;

import com.espot.employeemanagementapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByLastNameIgnoreCaseOrEmailIdIgnoreCase(String lastName, String emailId);

}
