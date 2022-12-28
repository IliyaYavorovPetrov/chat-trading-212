package com.trading212.chat.repository.entities;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table
public class User {

    @PrimaryKey
    private int id;

    private String firstName;

    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(int i) {
        this.id = i;
    }

    // Getters and setters
}

