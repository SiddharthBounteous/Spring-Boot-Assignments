package com.siddh.JDBCSpringDataJPAHibernateDemo.service.hibernate;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import com.siddh.JDBCSpringDataJPAHibernateDemo.repository.hibernate.HibernateEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HibernateEmployeeService {

    @Autowired
    private HibernateEmployeeRepository hibernateEmployeeRepository;

    public Employee findByEmployeeNameAndDepartment(String name,String department){
        return hibernateEmployeeRepository.findByNameAndDepartment(name,department);
    }
}
