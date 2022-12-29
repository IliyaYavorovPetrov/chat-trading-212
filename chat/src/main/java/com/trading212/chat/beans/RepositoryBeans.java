package com.trading212.chat.beans;

import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.repository.cassandra.CassandraUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
public class RepositoryBeans {
    @Bean
    public UserRepository userRepository(TransactionTemplate txTemplate, JdbcTemplate jdbcTemplate) {
        return new CassandraUserRepository(txTemplate, jdbcTemplate);
    }
}
