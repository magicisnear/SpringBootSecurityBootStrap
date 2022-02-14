package com.SpringBootCrud.JavaMentor.controllers;

import com.SpringBootCrud.JavaMentor.exceptions.ThisNameAlreadyExistsException;
import com.SpringBootCrud.JavaMentor.exceptions.UserIdNotFoundException;
import com.SpringBootCrud.JavaMentor.model.Role;
import com.SpringBootCrud.JavaMentor.service.RoleService;
import com.SpringBootCrud.JavaMentor.service.UserService;
import com.SpringBootCrud.JavaMentor.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String newPage(@AuthenticationPrincipal User user1, Model model) {
        model.addAttribute("users", userService.getAllUsers()); // список юзеров
        model.addAttribute("user1", user1); // текущий авторизированный пользователь
        model.addAttribute("user2", new User()); // для формы добавления юзеров
        model.addAttribute("setRoles", roleService.getAll()); // для формы добавления юзеров
        return "MainPage";
    }

    @GetMapping("/admin")
    public String findAll(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin-list";
    }

    @GetMapping("/admin/create")
    public String createUserForm(User user) {
        return "admin-create";
    }

    @PostMapping("/admin/create")
    public String createUser(User user) throws ThisNameAlreadyExistsException {
        if (userService.findByName(user.getName()).isPresent()) {
            throw new ThisNameAlreadyExistsException();
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/admin/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findByID(id));
        model.addAttribute("setRoles", roleService.getAll());
        return "admin-update";
    }

    @PostMapping("/admin/update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    //add method for new Site

    @PostMapping("/admin/save")
    public String save(User user) {
        if (userService.findByName(user.getName()).isPresent()) {
            throw new ThisNameAlreadyExistsException();
        }
        userService.saveUser(user);
        return "redirect:/";
    }

    @PostMapping("/admin/delete")
    public String delete(Long id, Model model) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/admin/findOne")
    @ResponseBody
    public Optional<User> findOne(Long id) {
        if(userService.findByID(id).isEmpty()) {
            throw new UserIdNotFoundException();
        }
        return userService.findByID(id);

    }
}
