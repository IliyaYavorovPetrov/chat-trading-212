package com.chattrading212.chat;

import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.cassandra.CassandraUserRepository;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.datastax.oss.driver.api.core.CqlSession;

import java.text.ParseException;

public class Chat {
    public static void main(String[] args) {
        try (CqlSession session = CqlSession.builder().build()) {
            UserRepository userRepository = new CassandraUserRepository(session);
            UserEntity userEntity = userRepository.createUser("ivan@gmail.com", "123", "ivanka");
            System.out.println("---->>>" + userEntity);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
