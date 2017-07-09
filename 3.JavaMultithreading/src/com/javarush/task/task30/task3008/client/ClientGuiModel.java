package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by User on 01.07.2017.
 */
public class ClientGuiModel {

    //2) Добавь в него множество(set) строк в качестве final поля allUserNames. В нем будет храниться список всех
    // участников чата. Проинициализируй его.
    private final Set<String> allUserNames = new HashSet<>();

    //3) Добавь поле String newMessage, в котором будет храниться новое сообщение, которое получил клиент.
    private String newMessage = null;

    //4) Добавь геттер для allUserNames, запретив модифицировать возвращенное множество. Разберись, как это
    // можно сделать с помощью метода класса Collections.
    public Set<String> getAllUserNames() {
        return Collections.unmodifiableSet(allUserNames);
    }

    //5) Добавь сеттер и геттер для поля newMessage.
    public String getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    //6) Добавь метод void addUser(String newUserName), который должен добавлять имя участника во множество, хранящее всех участников.
    public void addUser(String newUserName){
        allUserNames.add(newUserName);
    }

    /*7) Добавь метод void deleteUser(String userName), который будет удалять имя участника из множества.*/
    public void deleteUser(String userName){
        allUserNames.remove(userName);
    }

}
