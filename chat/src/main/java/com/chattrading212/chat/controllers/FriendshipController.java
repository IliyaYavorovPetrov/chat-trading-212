package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.FriendshipDto;
import com.chattrading212.chat.services.FriendshipService;
import com.chattrading212.chat.services.models.FriendshipModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FriendshipController {
    private final FriendshipService friendService;

    public FriendshipController(FriendshipService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/home/friends")
    public ResponseEntity<FriendshipDto> createFriendship(@RequestBody FriendshipDto friendsDto) {
        FriendshipModel friendsModel = friendService.createFriendship(friendsDto.userUuid, friendsDto.userNickname, friendsDto.userPictureId, friendsDto.friendUuid, friendsDto.friendNickname, friendsDto.friendPictureId);
        return ResponseEntity.ok(new FriendshipDto(friendsDto.userUuid, friendsDto.userNickname, friendsDto.userPictureId, friendsDto.friendUuid, friendsDto.friendNickname, friendsDto.friendPictureId));
    }
}
