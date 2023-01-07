package com.chattrading212.chat.services;

import com.chattrading212.chat.controllers.dtos.UserDto;
import com.chattrading212.chat.controllers.dtos.LoginDto;
import com.chattrading212.chat.controllers.dtos.RegisterDto;
import com.chattrading212.chat.controllers.dtos.UserDetailsDto;
import com.chattrading212.chat.mappers.UserDetailsMapper;
import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.services.models.UserModel;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.text.ParseException;

public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public UserDto login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password));
        UserModel userModel = UserMapper.toUserEntity(userRepository.getByEmail(loginDto.email));
        return new UserDto(jwtService.generateToken(UserDetailsMapper.toUserDetailsDto(userModel)), userModel.nickname, userModel.email);
    }

    public UserDto register(RegisterDto registerDto) throws ParseException {
        UserDetailsDto userDetailsDto = new UserDetailsDto(registerDto.email, registerDto.password, registerDto.roles, registerDto.isEnabled);
        userRepository.createUser(registerDto.email, passwordEncoder.encode(registerDto.password), registerDto.nickname);
        return new UserDto(jwtService.generateToken(userDetailsDto), registerDto.nickname, registerDto.email);
    }
}
