package com.example.Loc3_Spring_Security.security.manager;

import com.example.Loc3_Spring_Security.security.provider.CustomAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationManager  implements AuthenticationManager {
    private final CustomAuthenticationProvider authenticationProvider ;

    public CustomAuthenticationManager(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
       if (authenticationProvider.supports(authentication.getClass())){
           return authenticationProvider.authenticate(authentication);
       }

        throw new BadCredentialsException("mmmmmooooooooommmm nbfd") ;

    }
}
