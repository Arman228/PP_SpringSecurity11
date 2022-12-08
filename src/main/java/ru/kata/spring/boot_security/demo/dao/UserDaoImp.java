package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entity;


    @Override
    public void saveUser(User user) {
        entity.persist(user);

    }

    @Override
    public void saveRole(Role role) {
        entity.persist(role);
    }

    @Override
    public User getById(int id) {
        return entity.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        User user = entity.find(User.class, id);
        entity.remove(user);

    }


    @Override
    public void edit(User user) {
        entity.merge(user);


    }

    @Override
    public List<User> getAllUsers() {
        return entity.createQuery("select u from  User u", User.class).getResultList();
    }

    @Override
    public List<Role> getAllRolls() {
        return entity.createQuery("select u from Role u", Role.class).getResultList();
    }

    @Override
    public User findUserName(String name) {
        TypedQuery<User> query = entity.createQuery("select u from User u  where u.username =:username", User.class);
        query.setParameter("username", name);
        return query.getSingleResult();
    }


}





