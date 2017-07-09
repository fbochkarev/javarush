package com.javarush.task.task25.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/*Все не так легко, как кажется
    1. Почитать в инете про Socket, ThreadPoolExecutor, RunnableFuture, Callable.
    2. Реализуй логику метода cancel в классе SocketTask.
    3. Реализуй логику метода cancel для локального класса внутри метода newTask в классе SocketTask.

    Требования:
    1. Определение класса SocketTask, его поля и сигнатуры методов менять нельзя.
    2. Метод cancel в классе SocketTask должен закрывать используемые классом ресурсы.
    3. Метод cancel для локального класса внутри метода newTask должен закрывать ресурсы SocketTask и вызвать cancel
        у родительского класса.
    4. Метод у родительского класса должен быть вызван, даже если во время закрытия ресурсов было выкинуто исключение.*/

public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                try {
                    SocketTask.this.cancel();
                } finally {

                    return super.cancel(mayInterruptIfRunning);
                }
                //call super-class method in finally block

            }
        };
    }
}