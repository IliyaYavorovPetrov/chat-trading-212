package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.DirectMsgDto;
import com.chattrading212.chat.controllers.dtos.RequestDirectMsgDto;
import com.chattrading212.chat.mappers.DirectMsgMapper;
import com.chattrading212.chat.services.DirectMsgService;
import com.chattrading212.chat.services.models.DirectMsgModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class DirectMsgController {
    private final SimpMessagingTemplate template;
    private final DirectMsgService directMsgService;

    public DirectMsgController(DirectMsgService directMsgService, SimpMessagingTemplate template) {
        this.directMsgService = directMsgService;
        this.template = template;
    }

    @PostMapping("/home/chats")
    public ResponseEntity<Void> sendDirectMessage(@RequestBody RequestDirectMsgDto requestDirectMsgDto) {
        // sendDirectMessage handles POST request sent to server. It uses SimpMessagingTemplate to pass message to “/topic/message” destination.
        DirectMsgModel directMsgModel = directMsgService.createDirectMsg(requestDirectMsgDto.chatUuid, requestDirectMsgDto.msgText, requestDirectMsgDto.fromUserUuid, requestDirectMsgDto.fromUserNickname, requestDirectMsgDto.fromUserPictureId);
        template.convertAndSend("/user/" + requestDirectMsgDto.chatUuid + "/private", getDirectMsgsByChatUuid(requestDirectMsgDto.chatUuid));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/home/chats/{chatUuid}")
    public ResponseEntity<List<DirectMsgDto>> getDirectMsgsByChatUuid(@PathVariable UUID chatUuid) {
        List<DirectMsgModel> directMsgModelList = directMsgService.getDirectMsgsByChatUuid(chatUuid);
        List<DirectMsgDto> directMsgDtoList = new java.util.ArrayList<>(directMsgModelList.stream().map(DirectMsgMapper::toDirectMsgDto).toList());
        Collections.reverse(directMsgDtoList);
        return ResponseEntity.ok(directMsgDtoList);
    }

//    @MessageMapping("/sendMessage")
//    public void receiveDirectMessage(@Payload RequestDirectMsgDto textMessageDTO) {
//        // receiveDirectMessage is called whenever message is sent from client to “/app/sendMessage”. Here, “/app” prefix is from WebSocket Configuration. Please make note of annotations; MessageMapping and Payload.
//    }
//
//
//    @SendTo("/topic/message")
//    public RequestDirectMsgDto broadcastDirectMessage(@Payload RequestDirectMsgDto textMessageDTO) {
//        // broadcastDirectMessage method just return payload received from “/send” POST request. Returned value is received by clients register at “/topic/message”.
//        return textMessageDTO;
//    }
}
