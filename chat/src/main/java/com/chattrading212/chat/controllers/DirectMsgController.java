package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.DirectMsgDto;
import com.chattrading212.chat.controllers.dtos.RequestDirectMsgDto;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.models.DirectMsgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectMsgController {
    private final SimpMessagingTemplate template;
    private final DirectMsgService directMsgService;

    public DirectMsgController(DirectMsgService directMsgService, SimpMessagingTemplate template) {
        this.directMsgService = directMsgService;
        this.template = template;
    }

    @PostMapping("/home/chats")
    public ResponseEntity<DirectMsgDto> sendDirectMessage(@RequestBody RequestDirectMsgDto requestDirectMsgDto) {
        DirectMsgModel directMsgModel = directMsgService.createDirectMsg(requestDirectMsgDto.chatUuid, requestDirectMsgDto.msgText, requestDirectMsgDto.fromUserUuid, requestDirectMsgDto.fromUserNickname, requestDirectMsgDto.fromUserPictureId);
        template.convertAndSend("/topic/message", requestDirectMsgDto);
        return ResponseEntity.ok(new DirectMsgDto(directMsgModel.chatUuid, directMsgModel.createdAt, directMsgModel.isDeleted, directMsgModel.msgText, directMsgModel.fromUserUuid, directMsgModel.fromUserNickname, directMsgModel.fromUserPictureId));
    }

    @MessageMapping("/sendMessage")
    public void receiveDirectMessage(@Payload RequestDirectMsgDto textMessageDTO) {
        // receive message from client
    }


    @SendTo("/topic/message")
    public RequestDirectMsgDto broadcastDirectMessage(@Payload RequestDirectMsgDto textMessageDTO) {
        return textMessageDTO;
    }
}
