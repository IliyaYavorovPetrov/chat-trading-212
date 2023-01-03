package com.chattrading212.chat.config.spring.service;

import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    public UserService userService(UserRepository repository) {
        return new UserService(repository);
    }
}
