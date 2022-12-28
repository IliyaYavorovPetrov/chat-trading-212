package com.trading212.chat.repositories.cassandra;

import com.trading212.chat.repositories.UserRepository;
import com.trading212.chat.repositories.entities.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Objects;

import static com.trading212.chat.repositories.cassandra.CassandraQueries.INSERT_USER;

public class CassandraUserRepository implements UserRepository {
    private final TransactionTemplate transactionTemplate;
    private final JdbcTemplate jdbc;

    public CassandraUserRepository(TransactionTemplate transactionTemplate, JdbcTemplate jdbc) {
        this.transactionTemplate = transactionTemplate;
        this.jdbc = jdbc;
    }

    @Override
    public UserEntity createUser(String username, String password, String nickname) {
        return transactionTemplate.execute(status -> {
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbc.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, nickname);

                return preparedStatement;
            }, keyHolder);

            String userUUID = Objects.requireNonNull(keyHolder.getKey()).toString();
            return new UserEntity(userUUID, nickname, LocalDate.now(), password, username);
        });
    }
}
