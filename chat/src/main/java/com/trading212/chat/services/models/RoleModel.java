package com.trading212.chat.services.models;

public enum RoleModel {
    USER(1), ADMIN(2);

    public final int id;

    RoleModel(int id) {
        this.id = id;
    }

    static RoleModel fromID(int id) {
        return switch (id) {
            case 1 -> USER;
            case 2 -> ADMIN;
            default -> throw new RuntimeException("invalid role id");
        };
    }
}
