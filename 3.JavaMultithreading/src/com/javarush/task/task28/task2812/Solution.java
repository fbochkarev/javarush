package com.javarush.task.task28.task2812;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* 
ShutdownNow!
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {


        final ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;

            executor.submit(new Runnable() {
                public void run() {
/*                    List<Runnable> list = executor.shutdownNow();
                    if (executor.isTerminated()) System.out.println(list.get(localId) + " was not completed");*/
                    doExpensiveOperation(localId);
                }
            });

        }

        /*executor.shutdownNow();*/
        List<Runnable> list = executor.shutdownNow();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
/*        for (Runnable r: list
                ) {
            System.out.println(r);
        }*/
/*        for (Object x : list) {

            else System.out.println(x);
        }*/
        //
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId="+localId);
    }
}
