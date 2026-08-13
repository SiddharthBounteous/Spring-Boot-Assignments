package com.siddh.HibernateProblemDemo.repository;

import com.siddh.HibernateProblemDemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
