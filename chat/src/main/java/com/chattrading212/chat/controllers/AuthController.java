package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.UserDto;
import com.chattrading212.chat.controllers.dtos.LoginDto;
import com.chattrading212.chat.controllers.dtos.RegisterDto;
import com.chattrading212.chat.services.AuthService;
import com.chattrading212.chat.services.FriendshipService;
import com.chattrading212.chat.services.UserService;
import com.chattrading212.chat.services.models.FriendshipModel;
import com.chattrading212.chat.services.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
public class AuthController {
    private final AuthService authService;
    private final UserService userService;
    private final FriendshipService friendshipService;

    public AuthController(AuthService authService, UserService userService, FriendshipService friendshipService) {
        this.authService = authService;
        this.userService = userService;
        this.friendshipService = friendshipService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginDto loginDto) {
        UserModel userModel = userService.getByEmail(loginDto.email);
        if (userModel.isDeleted) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(authService.login(loginDto));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterDto registerDto) throws ParseException {
        if (userService.doesEmailExists(registerDto.email)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(authService.register(registerDto));
    }

    @PostMapping("/home/settings")
    public ResponseEntity<UserDto> deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto.userUuid);
        List<FriendshipModel> friendshipModelList = friendshipService.getUserFriendships(userDto.userUuid);

        for (var friendship : friendshipModelList) {
            friendship.isDeleted = true;
        }

        return ResponseEntity.ok(userDto);
    }
}
