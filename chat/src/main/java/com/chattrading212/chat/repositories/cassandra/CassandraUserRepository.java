package com.chattrading212.chat.repositories.cassandra;

import com.chattrading212.chat.repositories.UserRepository;
import com.chattrading212.chat.repositories.cassandra.queries.CassandraUserQueries;
import com.chattrading212.chat.repositories.entities.UserEntity;
import com.datastax.oss.driver.api.core.CqlSession;

import com.datastax.oss.driver.api.core.cql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.UUID;

public class CassandraUserRepository implements UserRepository {
    private final CqlSession session;

    @Autowired
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
        ResultSet resultSet = session.execute(CassandraUserQueries.DOES_UUID_EXIST, userUuid);
        Row row = resultSet.one();

        if (row != null) {
            long countUUID = row.getLong("count");

            return countUUID == 1;
        }

        return false;
    }

    @Override
    public UserEntity getByEmail(String email) {
        ResultSet resultSet = session.execute(CassandraUserQueries.GET_USER_BY_EMAIL, email);
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
    public Boolean doesEmailExists(String email) {
        ResultSet resultSet = session.execute(CassandraUserQueries.DOES_EMAIL_EXIST, email);
        Row row = resultSet.one();

        if (row != null) {
            long countUUID = row.getLong("count");

            return countUUID == 1;
        }

        return false;
    }
}
