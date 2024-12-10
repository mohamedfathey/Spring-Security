package com.example.Loc3_Spring_Security.security.authentication;

import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.security.auth.Subject;
import java.util.Collection;

//@Component
public class CustomAuthentication implements Authentication {

    private boolean authentication;
    private String kay;

    public CustomAuthentication(boolean authentication, String kay) {
        this.authentication = authentication;
        this.kay = kay;
    }

    public void setAuthentication(boolean authentication) {
        this.authentication = authentication;
    }

    public void setKay(String kay) {
        this.kay = kay;
    }

    public boolean isAuthentication() {
        return authentication;
    }

    public String getKay() {
        return kay;
    }

    @Override
    public boolean isAuthenticated() {
        return authentication;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

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
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return Authentication.super.implies(subject);
    }
}
