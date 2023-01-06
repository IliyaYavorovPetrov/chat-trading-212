package com.chattrading212.chat.auth;

import org.springframework.beans.factory.annotation.Value;

public class AuthConst {
    public static String SECRET_KEY = "357538782F413F442A472D4B6150645367566B59703373367639792442264529";

//    @Value("${auth.const.jwt.expiration}")
    public static Long JWT_EXPIRATION = 1440000L;
}
