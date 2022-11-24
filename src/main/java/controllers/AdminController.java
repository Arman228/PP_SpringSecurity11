package controllers;

import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import service.UserServiceImp;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/admin")
    public String userList(@ModelAttribute("users") Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        model.addAttribute("listRolls", userService.getAllRoles());
        return "admin";
    }

    @DeleteMapping("/admin")
    public String deleteUsers(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    @PostMapping
    public String addUsers(@ModelAttribute("users") User user, @RequestParam("roles_id") String role_id) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userService.findRollsbyId(role_id));
        return "redirect:/admin";                                                                      // прописать метод добавления
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
