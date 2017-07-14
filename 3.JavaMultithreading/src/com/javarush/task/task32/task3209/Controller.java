package com.javarush.task.task32.task3209;

import javax.swing.text.html.HTMLDocument;
import java.io.File;

/**
 * Created by BochkarevFY on 14.07.2017.
 */
public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
//        2.2.1. Создавать объект представления.
        View view = new View();
//        2.2.2. Создавать контроллер, используя представление.
        Controller controller = new Controller(view);
//        2.2.3. Устанавливать у представления контроллер.
        view.setController(controller);
//        2.2.4. Инициализировать представление.
        view.init();
//        2.2.5. Инициализировать контроллер. Контроллер должен инициализироваться после представления.
        controller.init();
//        2.3. Добавь в контроллер метод exit(), он должен вызывать статический метод exit у класса
//        System.
//        2.3.1. Метод exit в классе Controller не должен быть статическим.
//        2.4. Добавь в представление метод exit(), он должен вызывать exit() у контроллера.

    }

    public void init(){
        exit();
    }

    public void exit(){
        System.exit(0);
    }
}
