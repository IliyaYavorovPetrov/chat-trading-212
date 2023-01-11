package com.chattrading212.chat.services;

import com.chattrading212.chat.controllers.dtos.UserJwtDto;
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
import java.util.Random;
import java.util.UUID;

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

    public UserJwtDto login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email, loginDto.password));
        UserModel userModel = UserMapper.toUserModel(userRepository.getByEmail(loginDto.email));
        return new UserJwtDto(jwtService.generateToken(UserDetailsMapper.toUserDetailsDto(userModel)), userModel.userUuid, userModel.nickname, userModel.email, userModel.pictureId, userModel.isDeleted);
    }

    public UserJwtDto register(RegisterDto registerDto) throws ParseException {
        UserDetailsDto userDetailsDto = new UserDetailsDto(registerDto.email, registerDto.password, registerDto.roles, registerDto.isEnabled);
        UUID userUuid = UUID.randomUUID();
        Random random = new Random();
        Integer pictureId = random.nextInt(5);
        userRepository.createUser(userUuid, registerDto.email, passwordEncoder.encode(registerDto.password), registerDto.nickname, pictureId);
        UserModel userModel = UserMapper.toUserModel(userRepository.getByEmail(registerDto.email));
        return new UserJwtDto(jwtService.generateToken(userDetailsDto), userModel.userUuid, registerDto.nickname, registerDto.email, pictureId, userModel.isDeleted);
    }
}
