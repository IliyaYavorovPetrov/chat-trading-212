package com.trading212.chat.beans;

import com.datastax.oss.driver.api.core.CqlSession;
import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.repository.cassandra.CassandraUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryBeans {
    @Bean
    public UserRepository userRepository(CqlSession session) {
        return new CassandraUserRepository(session);
    }
}
