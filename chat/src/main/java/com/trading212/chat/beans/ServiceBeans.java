package com.trading212.chat.beans;

import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeans {
    @Bean
    public UserService userService(UserRepository repository) {
        return new UserService(repository);
    }
}
