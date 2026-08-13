package com.siddh.JDBCSpringDataJPAHibernateDemo.controller;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import com.siddh.JDBCSpringDataJPAHibernateDemo.service.hibernate.HibernateEmployeeService;
import com.siddh.JDBCSpringDataJPAHibernateDemo.service.jdbc.JdbcEmployeeService;
import com.siddh.JDBCSpringDataJPAHibernateDemo.service.jpa.JpaEmployeeService;
import com.siddh.JDBCSpringDataJPAHibernateDemo.service.springdata.SpringDataEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private HibernateEmployeeService hibernateEmployeeService;

    @Autowired
    private JpaEmployeeService jpaEmployeeService;

    @Autowired
    private JdbcEmployeeService jdbcEmployeeService;

    @Autowired
    private SpringDataEmployeeService springDataEmployeeService;

    @GetMapping("/jdbc")
    public Employee getEmployeeByJdbc(@RequestParam String name, @RequestParam String department){
        return jdbcEmployeeService.findByNameAndDepartment(name,department);
    }
    @GetMapping("/jpa")
    public Employee getEmployeeByJpa(@RequestParam String name, @RequestParam String department){
        return jpaEmployeeService.findByNameAndDepartment(name,department);
    }

    @GetMapping("/springjpa")
    public Employee getEmployeeBySpringdataJpa(@RequestParam String name, @RequestParam String department){
        return springDataEmployeeService.findByNameAndDepartment(name,department);
    }

    @GetMapping("/hibernate")
    public Employee getEmployeeByHibernate(@RequestParam String name,@RequestParam String department){
        return hibernateEmployeeService.findByEmployeeNameAndDepartment(name,department);
    }
}
