package com.siddh.HibernateProblemDemo.service;

import com.siddh.HibernateProblemDemo.entity.Department;
import com.siddh.HibernateProblemDemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        List<Department>departments=departmentRepository.findAll();
//        List<Department>departments=departmentRepository.findWithoutNPlusOne();

        return  departments;
    }

}
