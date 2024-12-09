package com.example.Loc2_Spring_Security.service;

import com.example.Loc2_Spring_Security.Repository.UserRepository;
import com.example.Loc2_Spring_Security.entity.User;
import com.example.Loc2_Spring_Security.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

 @Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository ;

     public JpaUserDetailsService(UserRepository userRepository) {
         this.userRepository = userRepository;
     }

     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = userRepository.findUserByUsername(username) ;
        return u.map(SecurityUser::new).orElseThrow(()->
                new UsernameNotFoundException("Username not found " + username)
                );
}

 }
