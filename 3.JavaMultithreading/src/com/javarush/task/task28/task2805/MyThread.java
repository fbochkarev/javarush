package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by User on 02.07.2017.
 */
public class MyThread extends Thread {
    int threadMaxPriority = Thread.MAX_PRIORITY;

    public MyThread() {
        Thread thread = new MyThread();
        for (int i = Thread.MIN_PRIORITY; i <  threadMaxPriority + 1; i++) {
            thread.setPriority(i);
        }
    }

    public MyThread(ThreadGroup group, String s) {

        threadMaxPriority = group.getMaxPriority();
        for (int i = Thread.MIN_PRIORITY; i < threadMaxPriority + 1; i++) {
            super.setPriority(i);
        }
    }
}
