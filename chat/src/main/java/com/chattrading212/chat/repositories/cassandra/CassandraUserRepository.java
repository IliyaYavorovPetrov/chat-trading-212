package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.UserRepository;
import com.datastax.oss.driver.api.core.CqlSession;

public class CassandraUserRepository implements UserRepository {
    private final CqlSession session;

    public CassandraUserRepository(CqlSession session) {
        this.session = session;
    }
}
