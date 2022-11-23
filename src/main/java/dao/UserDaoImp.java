package dao;


import model.Role;
import model.User;
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
    public void add(User user) {
        entity.persist(user);

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
    public void edit( int id, User user) {
        user.setId(id);
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
        TypedQuery<User> query=entity.createQuery("from User where username = :username", User.class );
        query.setParameter("username",name);
        return query.getSingleResult();
    }


}


