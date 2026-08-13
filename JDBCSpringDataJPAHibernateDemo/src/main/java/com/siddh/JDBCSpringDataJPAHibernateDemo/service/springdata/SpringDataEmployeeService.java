package com.siddh.JDBCSpringDataJPAHibernateDemo.service.springdata;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import com.siddh.JDBCSpringDataJPAHibernateDemo.repository.springdata.SpringdataEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringDataEmployeeService {

    @Autowired
    private SpringdataEmployeeRepository springdataEmployeeRepository;

    public Employee findByNameAndDepartment(String name,String department){
        return springdataEmployeeRepository.findByNameAndDepartment(name,department);
    }
}
