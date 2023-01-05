package com.chattrading212.chat.mappers;

import com.chattrading212.chat.controllers.dtos.UserDetailsDto;
import com.chattrading212.chat.services.models.UserModel;

import java.util.HashSet;

public class UserDetailsMapper {
    public static UserDetailsDto toUserDetailsDto(UserModel userModel) {
        return new UserDetailsDto(userModel.email, userModel.password, new HashSet<>(), true);
    }
}
