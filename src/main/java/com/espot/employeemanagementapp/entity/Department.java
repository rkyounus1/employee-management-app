package com.espot.employeemanagementapp.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="department")
public class Department {

    public Department() {
    }

    @OneToMany(mappedBy = "department")
     private List<Employee> employees;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name ="id")
    private Long id;

    @JsonProperty("departName")
    @Column(name ="departName")
    private String departName;
    @JsonProperty("number")
    @Column(name ="number")
    private long number;

    @JsonProperty("manager")
    @Column(name ="manager")
    private String manager;

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Department(String departName, long number, String manager) {
        this.departName = departName;
        this.number = number;
        this.manager = manager;
    }

}
