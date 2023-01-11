package com.chattrading212.chat.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Component
public class SocketIOConfig {
    private SocketIOServer server;

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        String socketHost = "http://localhost";
        config.setHostname(socketHost);
        int socketPort = 8088;
        config.setPort(socketPort);

        server = new SocketIOServer(config);
        server.start();
        server.addConnectListener(socketIOClient -> System.out.println("connected" + socketIOClient.getSessionId()));

        server.addDisconnectListener(client -> client.getNamespace().getAllClients().forEach(data-> {
        System.out.println("user disconnected "+data.getSessionId().toString());}));

        return server;
    }

    @PreDestroy
    public void stopSocketIOServer() {
        this.server.stop();
    }
}
