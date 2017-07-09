package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Handler;

/**
 * Created by User on 18.06.2017.
 */

public class Client extends Thread{
    protected Connection connection;
    private volatile boolean clientConnected = false;

/** Метод запрашивает ввод адреса сервера у пользователя и вернуть введенное значение. Адрес
    может быть строкой, содержащей ip, если клиент и сервер запущен на разных машинах или
    ‘localhost’, если клиент и сервер работают на одной машине.*/

    protected String getServerAddress() {
        String serverAddress;
        ConsoleHelper.writeMessage("Введите адрес сервера: ");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }

    /**Запрос порта сервера*/

    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера: ");
        int port = ConsoleHelper.readInt();
        return port;
    }

    /**Запрос имени пользователя*/

    protected String getUserName() throws IOException {
        ConsoleHelper.writeMessage("Введите имя: ");
        String userName = ConsoleHelper.readString();
        return userName;
    }

    /**Отвечает за вывод текста в консоль (в данной реализации клиента всегда должен возвращать true)*/

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    /**Создаёт и возвращает новый объект класса SocketThread*/

    protected SocketThread getSocketThread(){
        SocketThread socketThread = new SocketThread();
        return socketThread;
    }

    /**Отправка текстовых сообщений*/

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            clientConnected = false;
        }
    }

    public void run(){
        /**Создавать новый сокетный поток*/
        SocketThread socketThread = getSocketThread();
        /**Помечать созданный поток как daemon, это нужно для того, чтобы при выходе из программы
         * вспомогательный поток прервался автоматически*/
        socketThread.setDaemon(true);
        /**Запуск вспомогательно потока*/
        socketThread.start();
        /**Заставляем текущий поток ожидать, пока он не получит нотификацию из другого потока*/
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Error");
                return;
            }
        }

        if (clientConnected == true)
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду ‘exit’.");
        else ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");

        while (clientConnected){
            String inputMessege = ConsoleHelper.readString();
            if (inputMessege.equals("exit")) break;
            if (shouldSendTextFromConsole() == true) sendTextMessage(inputMessege);
        }

    }

    /**Класс отвечает за поток, устанавливающий сокетное соединение и читающий сообщения сервера*/

    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage("Пользователь " + userName + " подключился к чату");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage("Пользователь " + userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }

        //Метод представляет клиента серверу

        protected void clientHandshake() throws IOException, ClassNotFoundException{

            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.NAME_REQUEST){
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        //Метод реализовывает главный цикл обработки сообщений сервера.

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    processIncomingMessage(message.getData());
                } else if (message.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(message.getData());
                } else if (message.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(message.getData());
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        public void run(){
            try {
                connection = new Connection(new Socket(getServerAddress(), getServerPort()));
                clientHandshake();
                clientMainLoop();
            } catch (IOException e) {
                notifyConnectionStatusChanged(false);
            } catch (ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

}
