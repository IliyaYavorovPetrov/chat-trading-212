package com.chattrading212.chat.config;

import com.chattrading212.chat.repositories.FriendshipRepository;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.cassandra.CassandraFriendshipRepository;
import com.chattrading212.chat.repositories.cassandra.CassandraUserRepository;
import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public UserRepository userRepository(CqlSession session) {
        return new CassandraUserRepository(session);
    }

    @Bean
    public FriendshipRepository friendsRepository(CqlSession session) {
        return new CassandraFriendshipRepository(session);
    }
}
