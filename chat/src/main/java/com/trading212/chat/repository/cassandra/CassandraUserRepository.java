package com.trading212.chat.repository.cassandra;

import com.trading212.chat.repository.UserRepository;
import com.trading212.chat.repository.entities.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.util.Objects;

public class CassandraUserRepository implements UserRepository {
    private final TransactionTemplate txTemplate;
    private final JdbcTemplate jdbc;

    public CassandraUserRepository(TransactionTemplate txTemplate, JdbcTemplate jdbc) {
        this.txTemplate = txTemplate;
        this.jdbc = jdbc;
    }

    @Override
    public UserEntity crateUser(int id, String firstName, String lastName) {
        return txTemplate.execute(status -> {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbc.update(conn -> {
                PreparedStatement ps = conn.prepareStatement(
                        CassandraQueries.INSERT_USER);
                ps.setString(1, String.valueOf(id));
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                return ps;
            }, keyHolder);

            int idTemp = Objects.requireNonNull(keyHolder.getKey()).intValue();
            return new UserEntity(idTemp, firstName, lastName);
        });
    }
}
