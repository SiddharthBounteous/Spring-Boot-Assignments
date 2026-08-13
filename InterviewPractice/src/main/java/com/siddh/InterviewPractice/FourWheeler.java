package com.siddh.InterviewPractice;

import org.springframework.stereotype.Component;

@Component("FourWheelerBean")
public class FourWheeler implements VehicleInterface{
    @Override
    public int noOfWheels() {
        return 4;
    }
}
