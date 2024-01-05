package ru.alex.crudapp.dao;

import ru.alex.crudapp.entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    List<User> getListUsers();

    void deleteUser(int id);

    void updateUser(User user);
    User getUser(int id);
}
