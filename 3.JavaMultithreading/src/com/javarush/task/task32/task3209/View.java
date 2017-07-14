package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by BochkarevFY on 14.07.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;

//    3.1. Добавь и проинициализируй поля в классе представления:
//    3.1.1. JTabbedPane tabbedPane — это будет панель с двумя вкладками.
    private JTabbedPane tabbedPane = new JTabbedPane();
//    3.1.2. JTextPane htmlTextPane — это будет компонент для визуального редактирования html.
    private JTextPane htmlTextPane = new JTextPane();
//    Он будет размещен на первой вкладке.
//    3.1.3. JEditorPane plainTextPane — это будет компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое).
    private JEditorPane plainTextPane = new JEditorPane();

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {

        return controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public void init(){
        //      4.3. Реализуй метод init() представления. Он должен:
//      4.3.1. Вызывать инициализацию графического интерфейса initGui().
        initGui();
//      4.3.2. Добавлять слушателя событий нашего окна. В качестве подписчика создай и используй объект класса FrameListener.
//          В качестве метода для добавления подписчика используй подходящий метод из класса Window от которого наследуется и наш класс через классы JFrame и Frame.
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
//      4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.
//      На этом этапе приложение при запуске должно показывать окно, которое можно растягивать, разворачивать, закрыть и т.д.
        setVisible(true);
    }

    public void exit(){
        controller.exit();
    }
//      4.1. Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за инициализацию меню и панелей редактора.
    public void initMenuBar(){}
    public void initEditor(){}
//      4.2. Объяви в представлении метод initGui(). Он будет инициализировать графический интерфейс. Вызови из него инициализацию
//          меню initMenuBar(), инициализацию редактора initEditor() и метод pack(), реализацию которого мы унаследовали от класса JFrame.
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
//      Разберись что делает метод pack().
    public void selectedTabChanged(){}
}
