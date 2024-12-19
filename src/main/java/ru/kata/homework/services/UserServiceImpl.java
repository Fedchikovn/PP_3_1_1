package ru.kata.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.homework.dao.UserDao;
import ru.kata.homework.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao dao;

    @Autowired
    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public List<User> showAllUsers() {
        return dao.showAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return dao.getUserById(id);
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public void update(User user) {
        dao.update(user);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
