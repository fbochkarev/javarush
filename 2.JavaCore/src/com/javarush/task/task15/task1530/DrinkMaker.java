package com.javarush.task.task15.task1530;

/**
 * Created by User on 19.02.2017.
 */
public abstract class DrinkMaker {

    abstract void getRightCup();
    abstract void putIngredient();
    abstract void pour();

    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
    }

}
