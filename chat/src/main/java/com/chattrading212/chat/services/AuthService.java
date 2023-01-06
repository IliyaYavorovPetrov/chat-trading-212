package com.chattrading212.chat.services;

import com.chattrading212.chat.controllers.dtos.AuthDto;
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

    public AuthDto login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password));
        UserModel userModel = UserMapper.toUserEntity(userRepository.getByEmail(loginDto.email));
        return new AuthDto(jwtService.generateToken(UserDetailsMapper.toUserDetailsDto(userModel)));
    }

    public AuthDto register(RegisterDto registerDto) throws ParseException {
        UserDetailsDto userDetailsDto = new UserDetailsDto(registerDto.email, registerDto.password, registerDto.roles, registerDto.isEnabled);
        userRepository.createUser(registerDto.email, passwordEncoder.encode(registerDto.password), registerDto.nickname);
        return new AuthDto(jwtService.generateToken(userDetailsDto));
    }
}
