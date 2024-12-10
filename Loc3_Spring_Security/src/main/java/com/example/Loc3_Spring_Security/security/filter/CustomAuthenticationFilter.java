package com.example.Loc3_Spring_Security.security.filter;

import com.example.Loc3_Spring_Security.security.authentication.CustomAuthentication;
import com.example.Loc3_Spring_Security.security.manager.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
@Component
public class CustomAuthenticationFilter extends OncePerRequestFilter {

    private final CustomAuthenticationManager customAuthenticationManager ;

    public CustomAuthenticationFilter(CustomAuthenticationManager customAuthenticationManager) {
        this.customAuthenticationManager = customAuthenticationManager;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request
            , HttpServletResponse response
            , FilterChain filterChain) throws ServletException, IOException {

        String kay = String.valueOf(request.getHeader("kay"));

        CustomAuthentication ca = new CustomAuthentication(false,kay) ;
         // create authentication object which is not yet authenticated
          var a = customAuthenticationManager.authenticate(ca) ;
        // delegate the authentication object to the manager

        if (a.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request,response);
        }

    }
}
