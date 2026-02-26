package com.parking.car.dto;

public class Car {
    private Long regNumber;
    private String brand;
    private String carName;

    public Car(Long regNumber, String brand, String carName) {
        this.regNumber = regNumber;
        this.brand = brand;
        this.carName = carName;
    }

    public Long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Long regNumber) {
        this.regNumber = regNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
