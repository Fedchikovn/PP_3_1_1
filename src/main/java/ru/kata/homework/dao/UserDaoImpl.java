package ru.kata.homework.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.homework.models.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional(readOnly = true)
    public List<User> showAllUsers() {
        List<User> userList = entityManager.createQuery("select u from User u", User.class).getResultList();
        return userList;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        User userForDelete = entityManager.find(User.class, id);
        entityManager.remove(userForDelete);
    }
}
