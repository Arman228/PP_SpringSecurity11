package service;





import model.Role;
import model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

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



