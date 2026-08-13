package com.siddh.JDBCSpringDataJPAHibernateDemo.service.jpa;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import com.siddh.JDBCSpringDataJPAHibernateDemo.repository.jpa.JpaEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaEmployeeService {

    @Autowired
    private JpaEmployeeRepository jpaEmployeeRepository;

    public Employee findByNameAndDepartment(String name,String department){
        return jpaEmployeeRepository.findByNameAndDepartment(name,department);
    }
}
