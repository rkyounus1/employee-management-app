package com.espot.employeemanagementapp.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @JsonProperty("id")
    Long id;
    @JsonProperty("firstName")

    String firstName;
    @JsonProperty("lastName")

    String lastName;
    @JsonProperty("emailId")

    String emailId;

    public Employee(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }
}
