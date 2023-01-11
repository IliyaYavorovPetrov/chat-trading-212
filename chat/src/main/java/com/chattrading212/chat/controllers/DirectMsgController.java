package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.DirectMsgDto;
import com.chattrading212.chat.controllers.dtos.RequestDirectMsgDto;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.models.DirectMsgModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectMsgController {
    private final DirectMsgService directMsgService;

    public DirectMsgController(DirectMsgService directMsgService) {
        this.directMsgService = directMsgService;
    }

    @PostMapping("/home/chats")
    public ResponseEntity<DirectMsgDto> createDirectMsg(@RequestBody RequestDirectMsgDto requestDirectMsgDto) {
        DirectMsgModel directMsgModel = directMsgService.createDirectMsg(requestDirectMsgDto.chatUuid, requestDirectMsgDto.msgText, requestDirectMsgDto.fromUserUuid, requestDirectMsgDto.fromUserNickname, requestDirectMsgDto.fromUserPictureId);
        return ResponseEntity.ok(new DirectMsgDto(directMsgModel.chatUuid, directMsgModel.createdAt, directMsgModel.isDeleted, directMsgModel.msgText, directMsgModel.fromUserUuid, directMsgModel.fromUserNickname, directMsgModel.fromUserPictureId));
    }
}
