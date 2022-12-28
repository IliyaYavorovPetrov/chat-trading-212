package com.trading212.chat.controllers;

import com.trading212.chat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public void creatKurcho() {
        userService.createUser("kurcho", "123");
        System.out.println("aaa");
    }
}
