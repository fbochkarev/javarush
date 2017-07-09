package com.javarush.task.task29.task2909.car;

/**
 * Created by User on 26.05.2017.
 */
public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    public int getMaxSpeed() {
        final int MAX_SEDAN_SPEED = 120;
        return MAX_SEDAN_SPEED;
    }
}
