package ru.kata.spring.boot_security.demo.controllers;


import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping()
    public String pageForAuthentication(@AuthenticationPrincipal Principal principal, User user, Model model) {
        model.addAttribute("users", user);
        return "user";
    }




}