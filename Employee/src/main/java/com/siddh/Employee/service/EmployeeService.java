package com.siddh.Employee.service;

import com.siddh.Employee.dto.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeService {

    HashMap<Integer,Employee>mp=new HashMap<>();

    public Employee addEmployee(Employee employee){
        return mp.put(employee.getId(),employee);
    }

    public boolean deleteEmployee(Integer id){
        return mp.remove(id)!=null;
        //System.out.println("Employee deleted with id "+id);
    }

    public Employee getAllDetailsBasedOnId(Integer id){
        return mp.get(id);
    }

    public List<Employee> getAllEmployees(){
        List<Employee> li=new ArrayList<>();
        mp.forEach((key,value)->{
            li.add(value);
        });
        return li;
    }
}
