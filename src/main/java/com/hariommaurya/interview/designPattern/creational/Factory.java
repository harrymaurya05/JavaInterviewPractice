package com.hariommaurya.interview.designPattern.creational;

interface Vehicle{
    void increaseSpeed();
    void getPrice();
}
class Car implements Vehicle{

    @Override
    public void increaseSpeed() {
        System.out.println("Car Speed Increased!!");
    }

    @Override
    public void getPrice() {
        System.out.println("Car price!!");
    }
}
class Bike implements Vehicle{

    @Override
    public void increaseSpeed() {
        System.out.println("Bike Speed Increased!!");
    }

    @Override
    public void getPrice() {
        System.out.println("Bike price!!");
    }
}
class StatusFactory{
    public  Vehicle getVehicle(String type){
        if(type == "CAR"){
            return new Car();
        } else if (type == "BIKE") {
            return new Bike();
        }
        return null;
    }
}
public class Factory {
    public static void main(String[] args) {
        StatusFactory statusFactory = new StatusFactory();
        Vehicle vehicle = statusFactory.getVehicle("BIKE");
        vehicle.increaseSpeed();
    }
}
