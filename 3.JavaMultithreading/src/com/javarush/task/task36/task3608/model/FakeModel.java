package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 23.05.2017.
 */
public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

//    Метод void loadUsers() в классе FakeModel должен инициализировать список пользователей в объекте modelData любыми данными.

    @Override
    public void loadUsers() {
        List users = new ArrayList<>();
        users.add(new User("A", 1,1));
        users.add(new User("B", 2,1));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() { throw new UnsupportedOperationException(); }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {throw new UnsupportedOperationException(); }
}