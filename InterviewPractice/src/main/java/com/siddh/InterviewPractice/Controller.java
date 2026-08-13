package com.siddh.InterviewPractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    //@Qualifier: It is used when there are multiple beans of same type
    //("")-> always the bean name is to be added, if bean name is not there, then only it considers class name
    @Autowired
    @Qualifier("FourWheelerBean")  //use camel case for it
    private VehicleInterface vehicleInterface;

    @Autowired
//    @Qualifier("FirstEmployee")
    private Employee employee;

    @GetMapping("/noOfWheels")
    public int getNoOfWheels(){
        return vehicleInterface.noOfWheels();
    }

    @GetMapping("/employee")
    public String getEmployeeType(){
        return employee.getName();
    }
}
