package ru.alex.crudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.alex.crudapp.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/")
    public String getListUsers(Model model) {
        model.addAttribute("users", userService.getListUsers());
                return "users";
    }


}
