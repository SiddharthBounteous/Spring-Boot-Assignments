package com.parking.car.service;

import com.parking.car.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Service
public class CarService {



    HashMap<Long,Car>hashMap=new HashMap<>();


    public Car addCarInfo(Car car){
        return hashMap.put(car.getRegNumber(),car);
    }

    public Car getCarInfoFromRegNumber(Long id){
        return hashMap.get(id);
    }
}
