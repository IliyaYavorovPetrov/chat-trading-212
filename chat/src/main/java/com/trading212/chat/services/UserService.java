package com.trading212.chat.services;

import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.repository.entities.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String firstName, String lastName) {
        User user = new User();
        user.setId(1);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
    }
}
