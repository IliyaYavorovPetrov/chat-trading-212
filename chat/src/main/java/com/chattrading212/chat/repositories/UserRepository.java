package com.chattrading212.chat.repositories;

import com.chattrading212.chat.repositories.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserRepository extends UserDetailsService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    Optional<UserEntity> findByUsername(String username);
}
