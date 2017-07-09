package com.javarush.task.task26.task2610;

import java.util.concurrent.BlockingQueue;

/**
 * Created by User on 04.06.2017.
 * 5. Метод run() класса Consumer должен постоянно выводить на экран значения из очереди.
 */
public class Consumer implements Runnable{

    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
