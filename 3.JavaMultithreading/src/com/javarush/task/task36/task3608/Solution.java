package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();

        Controller controller = new Controller();

        EditUserView editUserView = new EditUserView();
        editUserView.setController(controller);
        controller.setEditUserView(editUserView);

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126L);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Anton",126, 10);
        usersView.fireEventShowDeletedUsers();

//        4. В методе main класса Solution необходимо вызвать метод открытия формы редактирования
//        для пользователя с id=126 у объекта класса UsersView перед вызовом метода fireEventShowDeletedUsers().
    }
}