package com.parking.car.controller;

import com.parking.car.dto.Car;
import com.parking.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    public HashMap<Long,Car> mp=new HashMap<>();


    @GetMapping("/name")
    public HashMap<Long,Car>getCarName(){
        return mp;
    }

    @GetMapping("/info/{id}")
    public Car getCarNameFromRegNumber(@PathVariable Long id){
        return mp.get(id);
    }



    @PostMapping("/addCarInfo/{id}")
    public String addCarInfo(@RequestBody Car car,@PathVariable Long id){
        mp.put(id,car);
        return "Car info added";
    }

    @DeleteMapping
    public String deleteCar(){
        mp.remove(1234L);
        return "deleted car info";
    }

    @PutMapping
    public String updateCarInfo(){
        mp.put(1001L,new Car(23456L,"Tata","nano"));
        return "Updated the info";
    }
}
