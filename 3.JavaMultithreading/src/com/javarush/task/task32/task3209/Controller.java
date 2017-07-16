package com.javarush.task.task32.task3209;

import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

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

//    14.2. Добавь в класс контроллера геттер для модели, в нашем случае это поле document.

    public HTMLDocument getDocument() {
        return document;
    }

//    Добавь в контроллер метод resetDocument(), который будет сбрасывать текущий документ. Он должен:
    public void resetDocument() {
//    15.1. Удалять у текущего документа document слушателя правок которые можно отменить/вернуть (найди подходящий для этого
//    метод, унаследованный от AbstractDocument). Слушателя нужно запросить у представления (метод getUndoListener()).
        if (document != null) document.removeUndoableEditListener(view.getUndoListener());
//    Не забудь проверить, что текущий документ существует (не null).
//    15.2. Создавать новый документ по умолчанию и присваивать его полю document.
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
//    Подсказка: воспользуйся подходящим методом класса HTMLEditorKit.
//
//    15.3. Добавлять новому документу слушателя правок.
        document.addUndoableEditListener(view.getUndoListener());
//    15.4. Вызывать у представления метод update().
        view.update();
    }

//    Добавь метод setPlainText(String text) в контроллер. Он будет записывать переданный текст с html тегами в документ
//      document. При его реализации:
    public void setPlainText(String text){
//    16.1. Сбрось документ.
        resetDocument();
//    16.2. Создай новый реадер StringReader на базе переданного текста.
        StringReader reader = new StringReader(text);
//    16.3. Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в
//    документ document.
        try {
            new HTMLEditorKit().read(reader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
//    16.4. Проследи, чтобы метод не кидал исключения. Их необходимо просто логировать.
    }

//    Добавь метод String getPlainText() в контроллер. Он должен получать текст из документа со всеми html тегами.
    public String getPlainText() {
//    17.1. Создай объект StringWriter.
        StringWriter stringWriter = new StringWriter();
//    17.2. Перепиши все содержимое из документа document в созданный объект с помощью
//    метода write класса HTMLEditorKit.
        try {
            new HTMLEditorKit().write(stringWriter, document, 0, document.getLength());
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
//    17.3. Как обычно, метод не должен кидать исключений.
        return String.valueOf(stringWriter);
    }
}
