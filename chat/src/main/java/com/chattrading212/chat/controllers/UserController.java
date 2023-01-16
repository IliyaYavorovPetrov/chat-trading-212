package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.*;
import com.chattrading212.chat.mappers.UserMapper;
import com.chattrading212.chat.services.AuthService;
import com.chattrading212.chat.services.FriendshipService;
import com.chattrading212.chat.services.MemberService;
import com.chattrading212.chat.services.UserService;
import com.chattrading212.chat.services.models.FriendshipModel;
import com.chattrading212.chat.services.models.UserModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    private final AuthService authService;
    private final UserService userService;
    private final FriendshipService friendshipService;
    private final MemberService memberService;

    public UserController(AuthService authService, UserService userService, FriendshipService friendshipService, MemberService memberService) {
        this.authService = authService;
        this.userService = userService;
        this.friendshipService = friendshipService;
        this.memberService = memberService;
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

    @GetMapping("/home/add/friends/uuid/{uuid}")
    public ResponseEntity<UserDto> getUserByUuid(@PathVariable UUID uuid) {
        UserDto userDto = UserMapper.toUserDto(userService.getByUUID(uuid));
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/home/add/friends/nickname/{nickname}/{uuid}")
    public ResponseEntity<List<UserDto>> getUserByNickname(@PathVariable String nickname, @PathVariable UUID uuid) {
        List<UserDto> usersDto = userService.getByNickname(nickname).stream().map(UserMapper::toUserDto).toList();
        List<FriendshipModel> friendshipModelList = friendshipService.getUserFriendships(uuid);

        List<UserDto> answ = new ArrayList<>();
        for (var x : usersDto) {
            Boolean foo = false;
            for (var y : friendshipModelList) {
                if (x.userUuid.equals(y.userUuid)) {
                    foo = true;
                    break;
                }
                if (x.userUuid.equals(y.friendUuid)) {
                    foo = true;
                    break;
                }
            }
            if (!foo) {
                answ.add(x);
            }
        }
        return ResponseEntity.ok(answ);
    }
}
