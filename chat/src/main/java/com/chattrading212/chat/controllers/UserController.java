package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.*;
import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.services.AuthService;
import com.chattrading212.chat.services.FriendshipService;
import com.chattrading212.chat.services.UserService;
import com.chattrading212.chat.services.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.UUID;

@RestController
public class UserController {
    private final AuthService authService;
    private final UserService userService;
    private final FriendshipService friendshipService;

    public UserController(AuthService authService, UserService userService, FriendshipService friendshipService) {
        this.authService = authService;
        this.userService = userService;
        this.friendshipService = friendshipService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserJwtDto> login(@RequestBody LoginDto loginDto) {
        UserModel userModel = userService.getByEmail(loginDto.email);
        if (userModel.isDeleted) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserJwtDto> register(@RequestBody RegisterDto registerDto) throws ParseException {
        if (userService.doesEmailExists(registerDto.email)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(authService.register(registerDto));
    }

    @PostMapping("/home/personal/info/delete")
    public ResponseEntity<UserJwtDto> deleteUser(@RequestBody UserJwtDto userDto) {
        UserJwtDto userDtoDeleted = UserMapper.toUserJwtDto(userDto.jwtToken, userService.deleteUser(userDto.userUuid));
        return ResponseEntity.ok(userDtoDeleted);
    }

    @GetMapping("/home/add/friends/{uuid}")
    public ResponseEntity<UserDto> getUserByUuid(@PathVariable UUID uuid) {
        UserDto userDto = UserMapper.toUserDto(userService.getByUUID(uuid));
        return ResponseEntity.ok(userDto);
    }
}
