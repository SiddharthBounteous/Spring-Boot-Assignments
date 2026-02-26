package com.siddh.Employee.controller;

import com.siddh.Employee.dto.Employee;
import com.siddh.Employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
//    public HashMap<Integer,Employee>mp=new HashMap<>();

    @GetMapping("/all")
    public List<Employee> getAllEmployeesList(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public Employee getAllDetailsBasedOnId(@PathVariable Integer id){
        return employeeService.getAllDetailsBasedOnId(id);
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Employee Created";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        boolean check=employeeService.deleteEmployee(id);
        if(check==true){
            return "Employee deleted successfully";
        }
        return "Employee Not found";
    }
}
