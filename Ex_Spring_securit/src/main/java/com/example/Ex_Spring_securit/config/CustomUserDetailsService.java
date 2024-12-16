package com.example.Ex_Spring_securit.config;

import com.example.Ex_Spring_securit.entity.Admin;
import com.example.Ex_Spring_securit.repo.AdminRepo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepo adminRepository; // Assuming you have a JPA repository for Admin

    public CustomUserDetailsService(AdminRepo adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Admin admin = adminRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Map the role to a granted authority
        return User.builder()
                .username(admin.getEmail())
                .password(admin.getPassword()) // Ensure password is encoded with BCrypt
                .authorities(admin.getRole().getName()) // Use role's name as authority
                .build();
    }
}
