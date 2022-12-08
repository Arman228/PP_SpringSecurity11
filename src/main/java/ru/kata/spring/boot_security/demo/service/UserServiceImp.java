package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.dao.UserDao;
import lombok.AllArgsConstructor;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImp implements UserService {
    //@Autowired
    private final UserDao dao;

    @Override
    public void add(User user) {
        dao.saveUser(user);

    }
    @Override
    public Set<Role> findRolesById(String RoleIds) {
        Set<Role> roles = new HashSet<>();
        for (Role role : getAllRoles()){
            if (RoleIds.contains(role.getId().toString())) {
                roles.add(role);
            }
        }
        return roles;
    }
    @Override
    public User getById(int id) {
        return dao.getById(id);
    }
    @Override
    public void delete(int id) {
        dao.delete(id);
    }
    @Override
    public void edit( User user) {
        dao.edit( user);
    }
    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
    @Override
    public List<Role> getAllRoles() {
        return dao.getAllRolls();
    }

    @Override
    public void addRolle(Role role) {
        dao.saveRole(role);
    }




}
