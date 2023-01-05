package com.chattrading212.chat.auth;

import org.springframework.beans.factory.annotation.Value;

public class AuthConst {
    @Value("${auth.const.secret.key}")
    public static String SECRET_KEY;

    @Value("${auth.const.jwt.expiration}")
    public static Long JWT_EXPIRATION;
}
