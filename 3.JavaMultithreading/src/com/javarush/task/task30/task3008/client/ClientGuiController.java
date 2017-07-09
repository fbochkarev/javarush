package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;

/**
 * Created by User on 01.07.2017.
 */
public class ClientGuiController extends Client {
    //2. Создай и инициализируй поле, отвечающее за модель ClientGuiModel model.
    private ClientGuiModel model = new ClientGuiModel();

    //3. Создай и инициализируй поле, отвечающее за представление ClientGuiView view. Подумай, что нужно передать
    // в конструктор при инициализации объекта.
    private ClientGuiView view = new ClientGuiView(this);

/*    4. Добавь внутренний класс GuiSocketThread унаследованный от SocketThread. Класс GuiSocketThread должен быть
    публичным. В нем переопредели следующие методы:
        а) void processIncomingMessage(String message) – должен устанавливать новое сообщение у модели и вызывать
    обновление вывода сообщений у представления.
        б) void informAboutAddingNewUser(String userName) – должен добавлять нового пользователя в модель и вызывать
    обновление вывода пользователей у отображения.
        в) void informAboutDeletingNewUser(String userName) – должен удалять пользователя из модели и вызывать
    обновление вывода пользователей у отображения.
        г) void notifyConnectionStatusChanged(boolean clientConnected) – должен вызывать аналогичный метод у представления.*/

    public class GuiSocketThread extends SocketThread{
        public void processIncomingMessage(String message){
            model.setNewMessage(message);
            view.refreshMessages();
        }

        public void informAboutAddingNewUser(String userName){
            model.addUser(userName);
            view.refreshUsers();
        }

        public void informAboutDeletingNewUser(String userName){
            model.deleteUser(userName);
            view.refreshUsers();
        }

        public void notifyConnectionStatusChanged(boolean clientConnected){
            view.notifyConnectionStatusChanged(clientConnected);
        }

    }

    /*5. Переопредели методы в классе ClientGuiController:
        а) SocketThread getSocketThread() – должен создавать и возвращать объект типа GuiSocketThread.
        б) void run() – должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run().
        Разберись, почему нет необходимости вызывать метод run в отдельном потоке, как мы это делали для консольного клиента.
        в) getServerAddress(), getServerPort(), getUserName(). Они должны вызывать одноименные методы из представления (view).*/
    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    public void run() {
        getSocketThread().run();
    }

    @Override
    public String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    public int getServerPort() throws IOException {
        return view.getServerPort();
    }

    @Override
    public String getUserName() throws IOException {
        return view.getUserName();
    }

    //6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
    public ClientGuiModel getModel(){
        return model;
    }

/*7. Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
    Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что
    все работает корректно.*/

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }

}
