package ru.kata.spring.boot_security.demo;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import service.UserService;
import service.UserServiceImp;
import util.Util;


@SpringBootApplication
public class SpringBootSecurityDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);

    }
}

