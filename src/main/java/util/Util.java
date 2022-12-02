package util;

import dao.UserDao;
import dao.UserDaoImp;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import service.UserService;
import service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
@AllArgsConstructor
public class Util {
    private final UserService service;
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void testStart() {

        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role( "ROLE_USER");
        service.addRolle(admin);
        service.addRolle(user);
        Set<Role> roles = new HashSet<>();


        roles.add(user);
        User newUser = new User("admin", "mainAdmin", "@gmail.com");
        newUser.setRoles(roles);
        newUser.setUsername("user");
        newUser.setPassword(passwordEncoder.encode("1234"));


        roles.add(user);
        roles.add(admin);
        User admin_user = new User("admin_user", "Maslov", "@mail.ru");
        admin_user.setPassword(passwordEncoder.encode("1234"));
        admin_user.setRoles(roles);
        admin_user.setUsername("admin");


        service.add(newUser);
        service.add(admin_user);


    }


    }


