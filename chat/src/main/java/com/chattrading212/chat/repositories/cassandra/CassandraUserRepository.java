package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CassandraUserRepository implements UserRepository {
    private final CqlSession session;

    public CassandraUserRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public UserEntity getByEmail(String email) {
        return null;
    }

    @Override
    public Boolean doesEmailExists(String email) {
        return null;
    }
}
