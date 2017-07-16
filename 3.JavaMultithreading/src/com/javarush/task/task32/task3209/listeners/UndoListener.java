package com.javarush.task.task32.task3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/**
 * Created by User on 15.07.2017.
 */
public class UndoListener implements UndoableEditListener {
//    11.3.1. Поле UndoManager undoManager.
    private UndoManager undoManager;

//    11.3.2. Конструктор, который принимает UndoManager и инициализирует поле класса.
    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

//    11.3.3. Метод undoableEditHappened(UndoableEditEvent e). Он должен из переданного события получать правку и добавлять ее в undoManager.
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }


}
