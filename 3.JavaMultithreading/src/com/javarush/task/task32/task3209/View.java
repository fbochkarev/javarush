package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by BochkarevFY on 14.07.2017.
 */
public class View extends JFrame implements ActionListener {
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);

//        9.2. Добавь конструктор класса View. Он должен устанавливать внешний вид и поведение (look and feel) нашего
//        приложения такими же, как это определено в системе.
//        Конструктор не должен кидать исключений, только логировать их с помощью ExceptionHandler.
//
//        Подсказа: для реализации задания используй класс UIManager.
//        Запусти приложение, теперь ты должен видеть панель с меню вверху окна. Некоторые из пунктов меню (например:
//        Вырезать, Копировать, Вставить, Стиль (частично), Выравнивание, Цвет, Шрифт) должны уже работать. Убедись, что
//        все работает и только затем продолжи разработку.
    public View() {
        try {
            UIManager.setLookAndFeel ( UIManager.getSystemLookAndFeelClassName() );
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }
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
//      В качестве метода для добавления подписчика используй подходящий метод из класса Window от которого наследуется и наш класс через классы JFrame и Frame.
        FrameListener frameListener = new FrameListener(this);
        this.addWindowListener(frameListener);
//      4.3.3. Показывать наше окно. Используй метод setVisible с правильным параметром.
//      На этом этапе приложение при запуске должно показывать окно, которое можно растягивать, разворачивать, закрыть и т.д.
        this.setVisible(true);
    }

    public void exit(){
        controller.exit();
    }
//      4.1. Объяви методы initMenuBar() и initEditor() в классе View. Они будут отвечать за инициализацию меню и панелей редактора.
    public void initMenuBar(){
//      9.1. Реализуй метод initMenuBar(). Он должен:
//      9.1.1. Создавать новый объект типа JMenuBar. Это и будет наша панель меню.
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar); //- Файл
        MenuHelper.initEditMenu(this, jMenuBar); // - Редактировать
        MenuHelper.initStyleMenu(this, jMenuBar); // - Стиль
        MenuHelper.initAlignMenu(this, jMenuBar); // - Выравнивание
        MenuHelper.initColorMenu(this, jMenuBar); // - Цвет
        MenuHelper.initFontMenu(this, jMenuBar); // - Шрифт
        MenuHelper.initHelpMenu(this, jMenuBar); // - Помощь
//      9.1.3. Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому, как это мы
//      делали с панелью вкладок.
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    public void initEditor(){
//      Реализуй метод инициализации панелей редактора initEditor(). Он должен:
//      6.1. Устанавливать значение «text/html» в качестве типа контента для компонента htmlTextPane.
//      Найди и используй подходящий метод.
        htmlTextPane.setContentType("text/html");
//      6.2. Создавать новый локальный компонент JScrollPane на базе htmlTextPane.
        JScrollPane jScrollPane = new JScrollPane(htmlTextPane);
//      6.3. Добавлять вкладку в панель tabbedPane с именем «HTML» и компонентом из предыдущего
//      пункта.
        tabbedPane.addTab("HTML", jScrollPane);
//      6.4. Создавать новый локальный компонент JScrollPane на базе plainTextPane.
        JScrollPane jScrollPane1 = new JScrollPane(plainTextPane);
//      6.5. Добавлять еще одну вкладку в tabbedPane с именем «Текст» и компонентом из
//      предыдущего пункта.
        tabbedPane.addTab("Текст", jScrollPane1);
//      6.6. Устанавливать предпочтительный размер панели tabbedPane.
        tabbedPane.setPreferredSize(new Dimension(100, 100));
//      6.7. Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя изменений в tabbedPane.
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
//      6.8. Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
//      Получить панель контента текущего фрейма можно с помощью метода getContentPane(), его реализация унаследовалась от JFrame.
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
//      После запуска приложения можно будет увидеть текущие результаты: две независимые закладки (HTML и Текст),
//      в каждой из которых можно набирать свой текст.

    }
//      4.2. Объяви в представлении метод initGui(). Он будет инициализировать графический интерфейс. Вызови из него инициализацию
//      меню initMenuBar(), инициализацию редактора initEditor() и метод pack(), реализацию которого мы унаследовали от класса JFrame.
    public void initGui(){
        initMenuBar();
        initEditor();
        pack();
    }
//      Разберись что делает метод pack()

//      11.5.3. Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.
    public boolean canUndo(){
        return undoManager.canUndo();
    }

    public boolean canRedo(){
        return undoManager.canRedo();
    }

//      11.5. Добавь в представление методы:
//      11.5.1. void undo() — отменяет последнее действие. Реализуй его используя undoManager.
    public void undo(){
        try {
            undoManager.undo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
//      Метод не должен кидать исключений, логируй их.
//      11.5.2. void redo() — возвращает ранее отмененное действие. Реализуй его по аналогии с предыдущим пунктом.
    public void redo(){
        try{
            undoManager.redo();
        } catch (Exception e){
            ExceptionHandler.log(e);
        }
    }
//      11.5.4. Реализуй геттер для undoListener.

    public UndoListener getUndoListener() {
        return undoListener;
    }

//      11.5.5. Добавь и реализуй метод void resetUndo(), который должен сбрасывать все правки в менеджере undoManager.
    public void resetUndo(){
        undoManager.discardAllEdits();
    }

//      13.1. Добавь в представление метод boolean isHtmlTabSelected(). Он должен возвращать true, если выбрана вкладка,
//      отображающая html в панели вкладок (подсказка: ее индекс 0).
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;
    }

//      14.1. Добавь в класс представления метод selectHtmlTab(). Он должен:
    public void selectHtmlTab(){
//      14.1.1. Выбирать html вкладку (переключаться на нее).
        tabbedPane.setSelectedIndex(0);
//      14.1.2. Сбрасывать все правки с помощью метода, который ты реализовал ранее.
        resetUndo();
    }

//        14.3. Добавь в представление метод update(), который должен получать документ у контроллера и устанавливать
//      его в панель редактирования htmlTextPane.
    public void update(){
        htmlTextPane.setDocument(controller.getDocument());
    }
//        14.4. Добавь в представление метод showAbout(), который должен показывать диалоговое окно с информацией о
//      программе. Информацию придумай сам, а вот тип сообщения должен быть JOptionPane.INFORMATION_MESSAGE.
    public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "Программа - HTML редактор из курса JavaRush", "message", JOptionPane.INFORMATION_MESSAGE);
    }

//    Реализуй метод selectedTabChanged() представления. Этот метод вызывается, когда произошла смена выбранной вкладки. Итак:
    public void selectedTabChanged(){
        //    18.1. Метод должен проверить, какая вкладка сейчас оказалась выбранной.
        Integer test = tabbedPane.getSelectedIndex();
        if (test == 0) {
            controller.setPlainText(plainTextPane.getText());
//    18.2. Если выбрана вкладка с индексом 0 (html вкладка), значит нам нужно получить текст из plainTextPane и установить
// его в контроллер с помощью метода setPlainText.
//    18.3. Если выбрана вкладка с индексом 1 (вкладка с html текстом), то необходимо получить текст у контроллера с помощью
// метода getPlainText() и установить его в панель plainTextPane.
        } else if (test == 1) {plainTextPane.setText(controller.getPlainText());}
//    18.4. Сбросить правки (вызвать метод resetUndo представления).
        resetUndo();
    }


}
