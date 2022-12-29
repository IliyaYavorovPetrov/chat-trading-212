package com.trading212.chat.repository.cassandra;

public class CassandraQueries {
    public static final String INSERT_USER = "INSERT INTO users(id, first_name, last_name) VALUES (?, ?, ?)";
}
