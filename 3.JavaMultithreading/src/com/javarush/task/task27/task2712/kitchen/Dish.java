package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish, Steak, Soup, Juice, Water;

   public static String allDishesToString(){
       String x = "";
       for (Dish s : Dish.values())
        x = x + " " + String.valueOf(s) + " ";
       return x;
   }
}
