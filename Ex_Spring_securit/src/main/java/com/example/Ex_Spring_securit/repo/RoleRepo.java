package com.example.Ex_Spring_securit.repo;

import com.example.Ex_Spring_securit.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role , Long> {
}
