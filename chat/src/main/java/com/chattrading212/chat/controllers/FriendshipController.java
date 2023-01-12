package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.*;
import com.chattrading212.chat.mappers.FriendshipMapper;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.FriendshipService;
import com.chattrading212.chat.services.models.FriendshipModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class FriendshipController {
    private final FriendshipService friendService;
    private final DirectMsgService directMsgService;

    private final SimpMessagingTemplate template;

    public FriendshipController(FriendshipService friendService, DirectMsgService directMsgService, SimpMessagingTemplate template) {
        this.friendService = friendService;
        this.directMsgService = directMsgService;
        this.template = template;
    }

    @GetMapping("/home/friends/get/{uuid}")
    public ResponseEntity<List<FriendDto>> getFriendshipsUser(@PathVariable UUID uuid) {
        List<FriendshipModel> friendshipModelList = friendService.getUserFriendships(uuid);
        List<FriendDto> friendDtoList = friendshipModelList.stream().map(x -> FriendshipMapper.toFriendDto(x, uuid)).toList();
        return ResponseEntity.ok(friendDtoList);
    }

    @PostMapping("/home/friends")
    public ResponseEntity<Void> createFriendship(@RequestBody RequestFriendshipDto requestFriendshipDto) {
        FriendshipModel friendsModel = friendService.createFriendship(requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId);
        directMsgService.createDirectMsg(friendsModel.friendshipUuid, "Hi", friendsModel.userUuid, friendsModel.userNickname, friendsModel.userPictureId);
//        FriendshipDto friendshipDto = new FriendshipDto(friendsModel.friendshipUuid, friendsModel.isDeleted, requestFriendshipDto.userUuid, requestFriendshipDto.userNickname, requestFriendshipDto.userPictureId, requestFriendshipDto.friendUuid, requestFriendshipDto.friendNickname, requestFriendshipDto.friendPictureId);
        List<FriendshipModel> friendsUser = friendService.getUserFriendships(friendsModel.userUuid);
        template.convertAndSend("/user/" + friendsModel.userUuid + "/private", friendsUser.stream().map(x -> FriendshipMapper.toFriendDto(x, friendsModel.userUuid)).toList());

        List<FriendshipModel> friendsFriend = friendService.getUserFriendships(friendsModel.userUuid);
        template.convertAndSend("/user/" + friendsModel.friendUuid + "/private", friendsFriend.stream().map(x -> FriendshipMapper.toFriendDto(x, friendsModel.friendUuid)).toList());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/home/friends/delete")
    public ResponseEntity<FriendshipDto> deleteFriendship(@RequestBody FriendshipDto friendshipDto) {
        FriendshipModel friendsModel = friendService.deleteFriendship(friendshipDto.friendshipUuid);
        return ResponseEntity.ok(new FriendshipDto(friendsModel.friendshipUuid, friendsModel.isDeleted, friendsModel.userUuid, friendsModel.userNickname, friendsModel.userPictureId, friendsModel.friendUuid, friendsModel.friendNickname, friendsModel.friendPictureId));
    }
}
