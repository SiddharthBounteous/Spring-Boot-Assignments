package com.siddh.JDBCSpringDataJPAHibernateDemo.entity;

import jakarta.persistence.*;

//@Entity: tells that the below class is a representation of a table
//@Table: tells the current mapping of a class to that table in db
@Entity
@Table(name="Employee")
public class Employee {

    @Column
    @Id   //maps the field to a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String department;

    public Employee(){

    }

    public Employee(Long id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
