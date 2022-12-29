package com.trading212.chat.repository.cassandra;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.repository.entities.UserEntity;

public class CassandraUserRepository implements UserRepository {
    private final CqlSession session;

    public CassandraUserRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public UserEntity crateUser(int id, String firstName, String lastName) {
        ResultSet resultSet = session.execute(CassandraQueries.INSERT_USER, id, firstName, lastName);

        UserEntity user = new UserEntity(100, "error", "error");
        for (Row x : resultSet) {
            int user_id = x.getInt("id");
            String first_name = x.getString("first_name");
            String last_name = x.getString("last_name");
            user = new UserEntity(user_id, first_name, last_name);
        }
        return user;
    }
}
