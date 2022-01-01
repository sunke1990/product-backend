package com.back.productbackend.global;

import com.back.productbackend.db.entity.SystemUserRole;
import com.back.productbackend.db.entity.User;
import lombok.Builder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @author sunke
 * @DATE 2021/12/31
 **/
@Builder
public class UserAuthentication implements Authentication {
    private User user;

    private List<SystemUserRole> roles;

    public User getUser() {
        return user;
    }

    public List<SystemUserRole> getRoles() {
        return roles;
    }

    public UserAuthentication(User user, List<SystemUserRole> roles) {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getName() {
        return null;
    }
}
