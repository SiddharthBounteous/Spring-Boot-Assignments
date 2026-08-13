package com.siddh.HibernateProblemDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //When returning JPA entities directly from a REST controller, Jackson tries to convert the whole object graph into JSON. If entities have bidirectional mapping like Department -> Employees -> Department, Jackson can go into infinite recursion.
    //. This is a JSON serialization problem. Jackson triggers object traversal, and Hibernate may load lazy fields during that traversal.

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    //We can solve JSON recursion using DTOs, or by using annotations like @JsonIgnore, @JsonManagedReference and @JsonBackReference. The best real-world approach is to return DTOs instead of exposing JPA entities directly.

    //It is bidirectional because both entities hold references to each other. Department has a list of employees using @OneToMany, and Employee has a department reference using @ManyToOne. So we can navigate from department to employees and also from employee back to department. This two-way navigation is called bidirectional mapping. In REST APIs, this can cause infinite JSON recursion if we return entities directly.
}
