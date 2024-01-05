package ru.alex.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alex.crudapp.entity.User;
import ru.alex.crudapp.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getListUsers(Model model) {
        model.addAttribute("users", userService.getListUsers());
        return "users";
    }

    @GetMapping("/user-create")
    public String addUser(User user) {
        return "/user-create";
    }

    @PostMapping("/user-create")
    public String saveUser(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/user-delete/id")
    public String deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/user-update/edit/id")
    public String updateUserForm(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "/user-update";
    }

    @PostMapping("/user-update/id")
    public String updateUser(@RequestParam int id, @ModelAttribute("user") User user, Model model) {
        User updateUser = userService.getUser(id);
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        userService.updateUser(updateUser);
        return "redirect:/";
    }


}
