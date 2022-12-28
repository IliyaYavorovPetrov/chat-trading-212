package com.trading212.chat.beans;

import com.trading212.chat.repositories.UserRepository;
import com.trading212.chat.repositories.cassandra.CassandraUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class RepositoryBeans {
    @Bean
    public UserRepository userRepository(TransactionTemplate transactionTemplate, JdbcTemplate jdbc) {
        return new CassandraUserRepository(transactionTemplate, jdbc);
    }
}
