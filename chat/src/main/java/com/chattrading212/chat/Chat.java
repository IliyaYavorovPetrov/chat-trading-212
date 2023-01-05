package com.chattrading212.chat;

import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.cassandra.CassandraUserRepository;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.datastax.oss.driver.api.core.CqlSession;

import java.text.ParseException;
import java.util.UUID;

public class Chat {
    public static void main(String[] args) {
        try (CqlSession session = CqlSession.builder().build()) {
            UserRepository userRepository = new CassandraUserRepository(session);
            userRepository.createUser("ilia@gmail.com", "1234", "Yunak");
            UUID uuid = UUID.fromString("07161ed7-a13d-491b-99aa-c9cecefde78a");
            UserEntity userEntity = userRepository.getByUUID(uuid);
            System.out.println(userEntity);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
