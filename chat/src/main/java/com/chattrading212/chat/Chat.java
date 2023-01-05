package com.chattrading212.chat;

import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.cassandra.CassandraUserRepository;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.datastax.oss.driver.api.core.CqlSession;

import java.text.ParseException;
import java.util.UUID;

public class Chat {
    public static void main(String[] args) {
//        try (CqlSession session = CqlSession.builder().build()) {
//            UserRepository userRepository = new CassandraUserRepository(session);
//            userRepository.createUser("ilia@gmail.com", "1234", "Yunak");
//            UUID uuid = UUID.fromString("c205a0db-f35b-44ef-bd21-abda117dcfc6");
//            UserEntity userEntity = userRepository.getByUUID(uuid);
//            System.out.println(userEntity);
//            System.out.println(userRepository.doesUUIDExists(uuid));
//
//            userEntity = userRepository.getByEmail("ilia@gmail.com");
//            System.out.println(userEntity);
//            System.out.println(userRepository.doesEmailExists(userEntity.email));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
    }
}
