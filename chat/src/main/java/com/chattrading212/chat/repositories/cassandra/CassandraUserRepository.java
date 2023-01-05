package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraUserQueries;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.datastax.oss.driver.api.core.CqlSession;

import com.datastax.oss.driver.api.core.cql.*;

import java.time.Instant;
import java.util.UUID;

public class CassandraUserRepository implements UserRepository {
    private final CqlSession session;

    public CassandraUserRepository(CqlSession session) {
        this.session = session;
    }

    @Override
    public void createUser(String email, String password, String nickname) {
        session.execute(CassandraUserQueries.CREATE_USER, email, password, nickname);
    }

    @Override
    public UserEntity getByUUID(UUID userUuid) {
        ResultSet resultSet = session.execute(CassandraUserQueries.GET_USER_BY_UUID, userUuid);
        Row row = resultSet.one();

        if (row != null) {
            UUID userEntityUuid = row.getUuid("user_uuid");
            String userEntityEmail = row.getString("email");
            String userEntityPassword = row.getString("password");
            String userEntityNickname = row.getString("nickname");
            Instant userEntityCreatedAt = row.getInstant("created_at");
            Boolean userEntityIsDeleted = row.getBoolean("is_deleted");

            return new UserEntity(userEntityUuid, userEntityEmail, userEntityPassword, userEntityNickname, userEntityCreatedAt, userEntityIsDeleted);
        }

        return null;
    }

    @Override
    public Boolean doesUUIDExists(UUID userUuid) {
        return null;
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
