package com.chattrading212.chat.controllers.dtos;

import com.chattrading212.chat.services.models.RoleModel;

import java.util.Set;

public class RegisterDto {
    public final String email;
    public final String password;
    public final String nickname;
    public final Set<RoleModel> roles;
    public final boolean isEnabled;

    public RegisterDto(String email, String password, String nickname, Set<RoleModel> roles, boolean isEnabled) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.roles = roles;
        this.isEnabled = isEnabled;
    }
}
