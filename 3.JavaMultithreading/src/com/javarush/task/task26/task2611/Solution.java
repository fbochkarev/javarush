package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
Мир не меняется, меняемся мы
Разберись с ConcurrentHashMap.
В отдельном файле создайте класс Producer, который будет:
1. каждые полсекунды добавлять в ConcurrentHashMap ключ и значение, где ключ — счетчик начиная с 1, значение — фраза: «Some text for i» , пример «Some text for 1«.
2. при возникновении исключения выводить в консоль: «[TREAD_NAME] thread was terminated«, пример «[thread-1] thread was terminated«.


Требования:
1. Класс Producer должен быть создан в отдельном файле.
2. Класс Producer должен реализовывать интерфейс Runnable.
3. Класс Producer должен содержать приватное поле ConcurrentHashMap map.
4. Класс Producer должен содержать конструктор с одним параметром, инициализирующий поле map.
5. Метод run() класса Producer должен каждые полсекунды добавлять в ConcurrentHashMap ключ и значение согласно заданию.
6. Метод run() класса Producer должен при возникновении исключения выводить в консоль "[TREAD_NAME] thread was terminated".
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        Producer producer = new Producer(map);
        Consumer consumer = new Consumer(map);

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(consumer);

        Thread.sleep(2000);

        executorService.shutdownNow();
        //finally 5 lines have to be printed
    }
}
