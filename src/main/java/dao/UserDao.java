package dao;



import model.Role;
import model.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    User getById(int id);

    void delete(int id);


    void edit(int id, User user);

    public List<User> getAllUsers();

    public List<Role>getAllRolls();

    public User findUserName(String name);


}



