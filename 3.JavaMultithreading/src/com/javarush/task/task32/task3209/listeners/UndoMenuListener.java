package com.javarush.task.task32.task3209.listeners;

import com.javarush.task.task32.task3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
 * Created by User on 15.07.2017.
 */
public class UndoMenuListener implements MenuListener {
//    «Отменить» и «Вернуть».
//    10.1. Добавь в класс UndoMenuListener следующие поля:
//    10.1.1. Представление View view.
    private View view;
//    10.1.2. Пункт меню «Отменить» JMenuItem undoMenuItem.
    private JMenuItem undoMenuItem;
//    10.1.3. Пункт меню «Вернуть» JMenuItem redoMenuItem.
    private JMenuItem redoMenuItem;
//    10.2. Реализуй конструктор UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem),
// он должен инициализировать поля класса.
    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }
//    10.3. Реализуй метод menuSelected(MenuEvent menuEvent). Он будет вызываться перед показом меню. Он должен:
    @Override
    public void menuSelected(MenuEvent menuEvent) {
//    10.3.1. Спрашивать у представления можем ли мы отменить действие с помощью метода boolean canUndo(). Пока у
//    представления нет такого метода, поэтому добавь заглушку, которая всегда возвращает false.

//    10.3.2. Делать доступным или не доступным пункт меню undoMenuItem в зависимости от того, что нам вернуло представление.
//
//    Подсказка: используй метод setEnabled().
        undoMenuItem.setEnabled(view.canUndo());
//    10.3.3. Аналогично поступи и для пункта меню redoMenuItem, добавив метод-заглушку canRedo() в представление.
//    Запусти программу и убедись, что пункты меню Отменить и Вернуть недоступны.
        redoMenuItem.setEnabled(view.canRedo());
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
