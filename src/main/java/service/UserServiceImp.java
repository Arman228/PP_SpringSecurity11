package service;


import dao.UserDao;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImp implements UserService {
    //@Autowired
    private final UserDao dao;

    public UserServiceImp(UserDao dao) {
        this.dao = dao;
    }

    @Transactional
    @Override
    public void add(User user) {
        dao.add(user);

    }
    @Override
    public Set<Role> findRollsbyId(String RoleIds) {
        Set<Role> roles = new HashSet<>();
        for (Role role : getAllRoles()){
            if (RoleIds.contains(role.getId().toString())) {
                roles.add(role);
            }
        }
        return roles;
    }

    @Override
    @Transactional
    public User getById(int id) {
        return dao.getById(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);

    }

    @Override
    @Transactional
    public void edit(int id, User user) {
        dao.edit(id, user);

    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public List<Role> getAllRoles() {
        return dao.getAllRolls();
    }




    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = dao.findUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");

        }
        return user;
    }
}
