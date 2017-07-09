package com.javarush.task.task15.task1529;

/**
 * Created by User on 19.02.2017.
 */
public class Plane implements Flyable{


    @Override
    public void fly() {

    }
    int count = 0;

    public Plane(int count) {
        this.count = count;
    }
}
