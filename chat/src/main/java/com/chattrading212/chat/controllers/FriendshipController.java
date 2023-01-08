package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.FriendshipDto;
import com.chattrading212.chat.controllers.dtos.RequestFriendshipDto;
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
    public ResponseEntity<FriendshipDto> createFriendship(@RequestBody RequestFriendshipDto requestFriendshipDto) {
        FriendshipModel friendsModel = friendService.createFriendship(requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId);
        return ResponseEntity.ok(new FriendshipDto(friendsModel.friendshipUuid, friendsModel.isDeleted, requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId));
    }

    @PostMapping("/home/friends/delete")
    public ResponseEntity<FriendshipDto> deleteFriendship(@RequestBody FriendshipDto friendshipDto) {
        FriendshipModel friendsModel = friendService.deleteFriendship(friendshipDto.friendshipUuid);
        return ResponseEntity.ok(new FriendshipDto(friendsModel.friendshipUuid, friendshipDto.isDelted, friendshipDto.userUuid, friendshipDto.userNickname, friendshipDto.userPictureId, friendshipDto.friendUuid, friendshipDto.friendNickname, friendshipDto.friendPictureId));
    }
}
