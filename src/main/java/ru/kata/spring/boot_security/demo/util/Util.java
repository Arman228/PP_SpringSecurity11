package ru.kata.spring.boot_security.demo.util;

import lombok.AllArgsConstructor;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.service.UserService;

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
        User newUser = new User("admin", "mainAdmin", "admin@gmail.com");
        newUser.setRoles(roles);
        newUser.setUsername("user");
        newUser.setPassword(passwordEncoder.encode("1234"));


        roles.add(user);
        roles.add(admin);
        User admin_user = new User("admin_user", "Maslov", "user@mail.ru");
        admin_user.setPassword(passwordEncoder.encode("1234"));
        admin_user.setRoles(roles);
        admin_user.setUsername("admin");


        service.add(newUser);
        service.add(admin_user);


    }


    }


