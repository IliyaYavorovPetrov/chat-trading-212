package com.chattrading212.chat.controllers;

import com.chattrading212.chat.controllers.dtos.DirectMsgDto;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SocketIOController {
    @Autowired
    private SocketIOServer socketServer;

    SocketIOController(SocketIOServer socketServer){
        this.socketServer=socketServer;
        this.socketServer.addConnectListener(onUserConnectWithSocket);
        this.socketServer.addDisconnectListener(onUserDisconnectWithSocket);
        this.socketServer.addEventListener("messageSendToUser", DirectMsgDto.class, onSendMessage);
    }

    public ConnectListener onUserConnectWithSocket = socketIOClient -> System.out.println("Perform operation on user connect in controller");

    public DisconnectListener onUserDisconnectWithSocket = client -> System.out.println("Perform operation on user disconnect in controller");

    public DataListener<DirectMsgDto> onSendMessage = new DataListener<DirectMsgDto>() {
        @Override
        public void onData(SocketIOClient client, DirectMsgDto message, AckRequest acknowledge) throws Exception {

            System.out.println(message.fromUserNickname+" user send message to user "+message.chatUuid+" and message is "+message.msgText);
            socketServer.getBroadcastOperations().sendEvent(message.chatUuid.toString(), client, message);
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };
}
