package com.trading212.chat.services.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
    private final int id;
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public UserModel(@JsonProperty("id") int id, @JsonProperty("first_name") String firstName, @JsonProperty("last_name") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
