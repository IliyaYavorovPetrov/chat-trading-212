package com.trading212.chat.repositories.cassandra;

public class CassandraQueries {
    // USERS
    public static final String INSERT_USER = "INSERT INTO users_by_nickname (nickname, password, username)";

    public static final String GET_USER = "SELECT * from users_by_nickname WHERE user_uuid = ?";
}
