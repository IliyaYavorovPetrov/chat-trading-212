package com.chattrading212.chat.services;

import com.chattrading212.chat.repositories.UserRepository;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }


}
