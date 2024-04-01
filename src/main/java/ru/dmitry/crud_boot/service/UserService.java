package ru.dmitry.crud_boot.service;

import ru.dmitry.crud_boot.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(int id);

    void save(User user);

    void update(int id, User updatedPerson);

    void delete(int id);
}
