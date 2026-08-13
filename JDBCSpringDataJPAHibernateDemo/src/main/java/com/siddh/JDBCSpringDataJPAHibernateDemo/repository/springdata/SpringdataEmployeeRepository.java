package com.siddh.JDBCSpringDataJPAHibernateDemo.repository.springdata;

import com.siddh.JDBCSpringDataJPAHibernateDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringdataEmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByNameAndDepartment(String name,String department);
}
