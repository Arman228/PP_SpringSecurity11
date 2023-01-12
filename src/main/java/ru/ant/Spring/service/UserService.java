package ru.ant.Spring.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ant.Spring.model.Role;
import ru.ant.Spring.model.User;

import java.util.Collection;
import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    User createUser(User user);

    void deleteUser(Integer id);

    void updateUser(Integer id, User user);



    User showUser(Integer id);

    Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles);

    User findByUsername(String username);
}
