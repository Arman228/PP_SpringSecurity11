package ru.kata.spring.boot_security.demo.service;





import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface UserService  {
    void add(User user);

    User getById(int id);

    void delete(int id);

    void edit( User user);

    public List<User> getAllUsers();

    public List<Role> getAllRoles();

    void addRolle(Role role);


    public Set<Role> findRolesById(String RoleIds);


}



