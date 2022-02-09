package com.SpringBootCrud.JavaMentor.controllers;

import com.SpringBootCrud.JavaMentor.model.Role;
import com.SpringBootCrud.JavaMentor.repository.UserRepository;
import com.SpringBootCrud.JavaMentor.userService.UserService;
import com.SpringBootCrud.JavaMentor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/new")
    public String newPage(@AuthenticationPrincipal User user1, Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users); // список юзеров
        model.addAttribute("user1", user1); // текущий авторизированный пользователь
        model.addAttribute("user2", new User()); // для формы добавления юзеров
        List<Role> roles = userService.listRoles();
        model.addAttribute("setRoles", roles); // для формы добавления юзеров
        return "Полный макет";
    }

    @GetMapping("/admin")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin-list";
    }

    @GetMapping("/admin/create")
    public String createUserForm(User user) {
        return "admin-create";
    }

    @PostMapping("/admin/create")
    public String createUser(User user, Model model) {
        model.addAttribute("user2", user);
        User userFromDB = userRepository.findByName(user.getName());
        if (userFromDB == null) {
            userService.saveUser(user);
        }
        return "redirect:/new";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/new";
    }

    @GetMapping("/admin/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findByID(id);
        List<Role> setRoles = userService.listRoles();
        model.addAttribute("user", user);
        model.addAttribute("setRoles", setRoles);
        return "admin-update";
    }

    @PostMapping("/admin/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/new";
    }

    //add method for new Site

    @PostMapping("/admin/save")
    public String save(User user) {
        userService.saveUser(user);
        return "redirect:/new";
    }

    @PostMapping("/admin/delete")
    public String delete(Long id, Model model) {
        userService.deleteById(id);
        return "redirect:/new";
    }

    @GetMapping("/admin/findOne")
    @ResponseBody
    public User findOne(Long id) {
        return userService.findByID(id);

    }
}
