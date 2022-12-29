package com.trading212.chat.repository.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.repository.entities.UserEntity;

public class CassandraUserRepository implements UserRepository {
    private final CqlSession session;

    public CassandraUserRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public UserEntity crateUser(int id, String firstName, String lastName) {
        session.execute(CassandraQueries.INSERT_USER);
        return null;
    }
}
