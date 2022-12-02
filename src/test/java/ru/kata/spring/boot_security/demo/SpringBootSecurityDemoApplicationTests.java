package ru.kata.spring.boot_security.demo;

import dao.UserDao;
import dao.UserDaoImp;
import model.Role;
import model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import service.UserService;
import service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.util.concurrent.Callable;

@SpringBootTest
class SpringBootSecurityDemoApplicationTests {
    private UserService userService;

    @Test
    void contextLoads() {
    }


    }




