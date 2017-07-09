package com.javarush.task.task30.task3008;

import com.javarush.task.task30.task3008.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by User on 12.06.2017.
 */

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    //Метод, который должен отправлять сообщение message всем соединениям из connectionMap

    public static void sendBroadcastMessage(Message message){
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            try {
                entry.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Error send message");
            }
        }
    }

    //Поток обработчик Handler, в котором будет происходить обмен сообщениями с клиентом

    private static class Handler extends Thread{
        Socket socket;

        public Handler(Socket socket){
            this.socket = socket;
        }

        //Этап рукопожатия (знакомства сервера с клиентом)

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                if (answer.getType().equals(MessageType.USER_NAME)){
                    if (!answer.getData().isEmpty()){
                        if (!connectionMap.containsKey(answer.getData())){
                            connectionMap.put(answer.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return answer.getData();
                        }
                    }
                }
            }
        }

        //Отправка клиенту (новому участнику) информации об остальных клиентах (участниках) чата

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> entry: connectionMap.entrySet()) {
                if (!connectionMap.containsKey(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
                }
            }
        }

        //Главный цикл обработки сообщений сервером

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {

                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    Message m2 = new Message(MessageType.TEXT, userName + ": " + message.getData());
                    sendBroadcastMessage(m2);
                }
            }
        }

        //Главный метод класса Handler, который будет вызывать все вспомогательные методы, написанные ранее

        @Override
        public void run() {
            System.out.println("Установлено новое соединение с удаленным адресом: " + socket.getRemoteSocketAddress());
            String userName = null;

            try {
                Connection connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                sendListOfUsers(connection, userName);
                serverMainLoop(connection, userName);
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));

            } catch (IOException e) {
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом");

            } catch (ClassNotFoundException e) {
                System.out.println("Произошла ошибка при обмене данными с удаленным адресом");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен");

            while (true){
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }

        } catch (IOException e) {
            serverSocket.close();
            System.out.println("Ошибка");
        }




    }
}