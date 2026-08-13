package com.siddh.JDBCSpringDataJPAHibernateDemo.service.jdbc;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import com.siddh.JDBCSpringDataJPAHibernateDemo.repository.jdbc.JdbcEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JdbcEmployeeService {

    @Autowired
    private JdbcEmployeeRepository jdbcEmployeeRepository;

    public Employee findByNameAndDepartment(String name,String department){
        return jdbcEmployeeRepository.findByNameAndDepartment(name,department);
    }
}
