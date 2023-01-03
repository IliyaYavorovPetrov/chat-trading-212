package com.chattrading212.chat.services;

import com.chattrading212.chat.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService{
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
}
