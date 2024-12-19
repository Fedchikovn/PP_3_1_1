package ru.kata.homework.services;
import ru.kata.homework.models.User;

import java.util.List;

public interface UserService {
    List<User> showAllUsers();

    User getUserById(int id);
    void save(User user);
    void update(User user);
    void deleteById(int id);

}
