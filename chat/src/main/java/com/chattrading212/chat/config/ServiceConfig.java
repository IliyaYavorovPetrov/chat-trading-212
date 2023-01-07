package com.chattrading212.chat.config;

import com.chattrading212.chat.repositories.FriendsRepository;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.services.AuthService;
import com.chattrading212.chat.services.FriendService;
import com.chattrading212.chat.services.JwtService;
import com.chattrading212.chat.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfig {
    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }

    @Bean
    public AuthService authService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        return new AuthService(userRepository, passwordEncoder, jwtService, authenticationManager);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public FriendService friendsService(FriendsRepository friendsRepository) {
        return new FriendService(friendsRepository);
    }
}
