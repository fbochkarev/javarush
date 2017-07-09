package com.javarush.task.task25.task2504;


/*
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread x: threads) {
            switch(x.getState()){
                case NEW: x.start();
                break;
                case WAITING: x.interrupt();
                break;
                case BLOCKED: x.interrupt();
                break;
                case TIMED_WAITING: x.interrupt();
                break;
                case RUNNABLE: x.isInterrupted();
                break;
                case TERMINATED:
                    System.out.println(x.getPriority());
                    break;
            }
        }

    }

    public static void main(String[] args) {

        System.out.println();

    }
}
