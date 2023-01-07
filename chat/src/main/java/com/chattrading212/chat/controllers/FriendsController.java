package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.FriendsDto;
import com.chattrading212.chat.services.FriendService;
import com.chattrading212.chat.services.models.FriendsModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class FriendsController {
    private final FriendService friendService;

    public FriendsController(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/home/friends")
    public ResponseEntity<FriendsDto> createFriendship(@RequestBody FriendsDto friendsDto)  throws ParseException {
        FriendsModel friendsModel = friendService.createFriendship(friendsDto.userUuid, friendsDto.userNickname, friendsDto.userPictureId, friendsDto.friendUuid, friendsDto.friendNickname, friendsDto.friendPictureId);
        return ResponseEntity.ok(new FriendsDto(friendsDto.userUuid, friendsDto.userNickname, friendsDto.userPictureId, friendsDto.friendUuid, friendsDto.friendNickname, friendsDto.friendPictureId));
    }
}
