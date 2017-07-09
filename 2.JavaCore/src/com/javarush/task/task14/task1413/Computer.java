package com.javarush.task.task14.task1413;

/**
 * Created by User on 12.02.2017.
 * 6. В класс Computer добавь приватное поле keyboard типа Keyboard.
 7. В класс Computer добавь приватное поле mouse типа Mouse.
 8. В класс Computer добавь приватное поле monitor типа Monitor.
 9. Создай конструктор с тремя параметрами в классе Computer используя комбинацию клавиш Alt+Insert внутри класса (команда Constructor).
 10 Внутри конструктора инициализируйте все три поля (переменных) класса в соответствии с переданными параметрами.
 11. Создай геттеры для полей класса Computer (в классе используй комбинацию клавиш Alt+Insert и выбери команду Getter).
 */
public class Computer {

    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
