package ru.ant.Spring.init;

import org.springframework.beans.factory.annotation.Autowired;
import ru.ant.Spring.model.Role;
import ru.ant.Spring.model.User;
import ru.ant.Spring.service.RoleService;
import ru.ant.Spring.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Initial {


    private RoleService roleService;

    private UserService userService;

    @Autowired
    public Initial(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @PostConstruct
    public void creat() {
        if (roleService.getAllRoles().isEmpty()) {
            Role admin=new Role(1,"ROLE_ADMIN");
            Role user=new Role(2,"ROLE_USER");
            roleService.addRole(admin);
            roleService.addRole(user);
            List<Role> setRole = new ArrayList<>();
            setRole.add(admin);
            User newAdmin = new User(1,"Artur","Mikayelyan","A","abc","abc2",setRole);

            userService.createUser(newAdmin);

            System.out.println("hello, I have just create few users: \n" +
                    "username: Alex      password: 1 \n");
        }
    }

        }



