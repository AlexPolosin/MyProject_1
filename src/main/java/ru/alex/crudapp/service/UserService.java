package ru.alex.crudapp.service;

import ru.alex.crudapp.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    List<User> getListUsers();

    void deleteUser(int id);

    void updateUser(int id);
    User getUser(int id);
}
