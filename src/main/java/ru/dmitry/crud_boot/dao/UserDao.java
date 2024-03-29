package ru.dmitry.crud_boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.crud_boot.model.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
