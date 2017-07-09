package com.javarush.task.task29.task2909.car;

/**
 * Created by User on 26.05.2017.
 */
public class Truck extends Car {
    public Truck(int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }

    public int getMaxSpeed() {
        final int MAX_TRUCK_SPEED = 80;
        return MAX_TRUCK_SPEED;
    }
}
