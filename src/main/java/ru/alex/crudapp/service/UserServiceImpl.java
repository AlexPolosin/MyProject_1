package ru.alex.crudapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alex.crudapp.dao.UserDao;
import ru.alex.crudapp.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) { userDao.addUser(user); }

    @Override
    public List<User> getListUsers() { return userDao.getListUsers(); }

    @Override
    public void deleteUser(int id) { userDao.deleteUser(id); }

    @Override
    public void updateUser(int id) { userDao.updateUser(id); }

    @Override
    public User getUser(int id) { return userDao.getUser(id); }
}
