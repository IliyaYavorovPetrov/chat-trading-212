package com.trading212.chat.controllers;

import com.trading212.chat.services.UserService;
import com.trading212.chat.services.models.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public UserModel creatUser() {
        return  userService.createUser(3, "gosho", "petrov");
    }
}
