package com.palarczyk.socialmedia.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

public class CurrentUser extends User {

    private final com.palarczyk.socialmedia.domain.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       com.palarczyk.socialmedia.domain.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public com.palarczyk.socialmedia.domain.User getUser() {
        return user;
    }
}
