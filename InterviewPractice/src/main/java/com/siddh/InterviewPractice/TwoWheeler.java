package com.siddh.InterviewPractice;

import org.springframework.stereotype.Component;

@Component
public class TwoWheeler implements VehicleInterface {
    public int noOfWheels() {
        return 2;
    }
}
