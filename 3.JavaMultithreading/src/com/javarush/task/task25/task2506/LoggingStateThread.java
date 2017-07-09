package com.javarush.task.task25.task2506;

/**
 * Created by User on 27.05.2017.
 */

/*
Мониторинг состояния нити
Cоздай класс нити LoggingStateThread, которая будет выводить в консоль все состояния (State) переданной в конструктор нити.
Нить LoggingStateThread должна сама завершаться после остановки переданной в конструктор нити.
Метод main не участвует в тестировании.


Требования:
1. Создай класс LoggingStateThread. Он должен наследовать класс Thread.
2. Класс LoggingStateThread должен содержать поле нити, за которой он будет следить.
Это поле должно инициализироваться через конструктор.
3. Переопредели метод run в классе LoggingStateThread.
4. После запуска класс LoggingStateThread должен выводить в консоль изменения состояния переданной нити.
5. После завершения работы наблюдаемой нити, LoggingStateThread так же должен завершить работу.
*/
public class LoggingStateThread extends Thread{
    Thread thread;
    private State prevState = null;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        thread.setDaemon(true);
    }

    public void run(){
        while (true) {
            State state = thread.getState();
            if (prevState == null) {
                prevState = state;
                System.out.println(state.toString());
            } else if (!state.equals(prevState)) {
                System.out.println(state.toString());
                prevState = state;
            }
            if (state.equals(State.TERMINATED)) { break; }
        }
    }
}
