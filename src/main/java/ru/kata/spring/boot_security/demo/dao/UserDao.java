package ru.kata.spring.boot_security.demo.dao;



import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void saveRole(Role role);

    User getById(int id);

    void delete(int id);


    void edit( User user);

    public List<User> getAllUsers();

    public List<Role> getAllRolls();

    public User findUserName(String name);
}








