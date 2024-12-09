package com.example.Loc2_Spring_Security.security;

import com.example.Loc2_Spring_Security.entity.Authorities;
import org.springframework.security.core.GrantedAuthority;

public class SecurityAuthority implements GrantedAuthority {

    private final Authorities authorities ;

    public SecurityAuthority(Authorities authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getAuthority() {
        return authorities.getName();
    }
}
