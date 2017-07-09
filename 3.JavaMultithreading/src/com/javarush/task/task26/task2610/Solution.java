package com.javarush.task.task26.task2610;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
Мир скучен для скучных людей
Разберись с BlockingQueue.
По образу и подобию класса Producer создай класс Consumer, который будет выводить данные из BlockingQueue в консоль.


Требования:
1. Класс Consumer должен быть создан в отдельном файле.
2. Класс Consumer должен реализовывать интерфейс Runnable.
3. Класс Consumer должен содержать приватное поле BlockingQueue queue.
4. Класс Consumer должен содержать конструктор с одним параметром, инициализирующий поле queue.
5. Метод run() класса Consumer должен постоянно выводить на экран значения из очереди.
*/
public class Solution {

    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(32);

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();

    }
}
