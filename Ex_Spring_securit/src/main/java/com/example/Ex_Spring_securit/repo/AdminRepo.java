package com.example.Ex_Spring_securit.repo;

import com.example.Ex_Spring_securit.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepo extends JpaRepository<Admin , Long> {
    Optional<Admin> findByEmail(String email);
}
