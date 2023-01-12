package ru.ant.Spring.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ant.Spring.model.User;
import ru.ant.Spring.service.RoleService;
import ru.ant.Spring.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    private RoleService service;

    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/admin")
    public String userList(@ModelAttribute("users") Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("listRolls", service.getAllRoles());
        return "admin";
    }

    @DeleteMapping("/admin")
    public String deleteUsers(@RequestParam("id") int id) {
      userService.deleteUser(id);
        return "redirect:/admin";
    }
    @PostMapping
    public String addUser(@RequestParam("rolesId") String rolesId, @ModelAttribute("user") User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userService.findByUsername(rolesId).getRoles());
        userService.createUser(user);
        return "redirect:/admin";
    }

    @PatchMapping
    public String updateUsers(@RequestParam("id") int id, @ModelAttribute("users") User user,
                              @RequestParam("roles_id") String roles_id) {
        if (user.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(roles_id));


        }

        return "redirect:/admin";
    }


}
