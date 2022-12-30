package com.trading212.chat.auth;

import com.trading212.chat.services.models.RoleModel;
import org.springframework.security.core.GrantedAuthority;

public abstract class Authorities {
    static class UserAuthority implements GrantedAuthority {
        @Override
        public String getAuthority() {
            return RoleModel.USER.name();
        }
    }

    static class AdminAuthority implements GrantedAuthority {
        @Override
        public String getAuthority() {
            return RoleModel.ADMIN.name();
        }
    }

    static GrantedAuthority fromRole(RoleModel roleModel) {
        return switch (roleModel) {
            case USER -> new UserAuthority();
            case ADMIN -> new AdminAuthority();
        };
    }
}
