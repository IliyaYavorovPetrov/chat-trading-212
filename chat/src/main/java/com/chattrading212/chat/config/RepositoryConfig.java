package com.chattrading212.chat.config;

import com.chattrading212.chat.repositories.FriendsRepository;
import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.cassandra.CassandraFriendsRepository;
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
    public FriendsRepository friendsRepository(CqlSession session) {
        return new CassandraFriendsRepository(session);
    }
}
