package com.siddh.HibernateProblemDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Even though it is LAZY, Jackson still sees the field/getter while converting to JSON and tries to serialize it.

    @JsonIgnore
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees;

    //To fill employees, Jackson internally calls:
    //department.getEmployees()
    //That access triggers Hibernate lazy loading:
    //select * from employee where department_id = ?;

    //Lazy association accessed repeatedly for multiple parent records
}
