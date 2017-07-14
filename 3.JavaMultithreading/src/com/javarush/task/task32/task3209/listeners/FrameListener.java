package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by BochkarevFY on 14.07.2017.
 */
public class FrameListener extends WindowAdapter{
//    3.2. Добавь класс FrameListener в пакет listeners. Он должен:
//    3.2.1. Быть унаследован от WindowAdapter.
//    3.2.2. Иметь поле View view.
    private View view;
//    3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.

    public FrameListener(View view) {
        this.view = view;
    }

//    3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent), который должен вызывать exit() у представления.
    @Override
    public void windowClosing(WindowEvent e) {
        view.exit();
    }

}
