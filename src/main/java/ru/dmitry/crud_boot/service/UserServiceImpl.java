package ru.dmitry.crud_boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dmitry.crud_boot.dao.UserDao;
import ru.dmitry.crud_boot.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int id) {
        Optional<User> foundPerson = userDao.findById(id);

        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(int id, User updatedPerson) {
        updatedPerson.setId(id);
        userDao.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        userDao.deleteById(id);
    }
}
