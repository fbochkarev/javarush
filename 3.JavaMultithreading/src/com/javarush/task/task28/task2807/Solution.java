package com.javarush.task.task28.task2807;

import java.util.Queue;
import java.util.concurrent.*;

/* 
Знакомство с ThreadPoolExecutor
*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here
        //1. В методе main создай очередь LinkedBlockingQueue<Runnable>.
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();


        //2. В цикле добавь в очередь 10 задач Runnable.
        for (int i = 0; i < 10; i++) {
            final int finalI = i + 1;
            queue.add(new Runnable(){

                @Override
                public void run() {
                    //У каждой задачи в методе run вызови метод doExpensiveOperation с порядковым номером
                    // задачи начиная с 1, см. пример вывода.
                    doExpensiveOperation(finalI);
                }
            });
        }

/*      4. Создай объект ThreadPoolExecutor со следующими параметрами:
        — основное количество трэдов (ядро) = 3,
        — максимальное количество трэдов = 5,
        — время удержания трэда живым после завершения работы = 1000,
        — тайм-юнит — миллисекунды,
        — созданная в п.1. очередь с задачами.*/

        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, queue);
        executor.prestartAllCoreThreads();
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

/*


        5. Запусти все трэды, которые входят в основное кол-во трэдов — ядро, используй метод prestartAllCoreThreads.
        6. Запрети добавление новых задач на исполнение в пул (метод shutdown).
        7. Дай объекту ThreadPoolExecutor 5 секунд на завершение всех тасок (метод awaitTermination и параметр TimeUnit.SECONDS).*/

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-3, localId=3
pool-1-thread-1, localId=1
pool-1-thread-3, localId=5
pool-1-thread-2, localId=4
pool-1-thread-3, localId=7
pool-1-thread-1, localId=6
pool-1-thread-3, localId=9
pool-1-thread-2, localId=8
pool-1-thread-1, localId=10
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}

/*
    Знакомство с ThreadPoolExecutor



        Требования:
        1. В методе main нужно создать очередь LinkedBlockingQueue.
        2. В цикле добавь в очередь 10 задач Runnable.
        3. Нужно создать объект ThreadPoolExecutor с параметрами, указанными в задании.
        4. С помощью метода prestartAllCoreThreads нужно запустить основные трэды.
        5. Каждая задача должна вызывать метод doExpensiveOperation с порядковым номером задачи, начиная с 1.
        6. Запрети добавление новых задач на исполнение в пул.
        7. На завершение всех задач в пуле нужно установить 5 секунд..*/
