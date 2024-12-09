package com.example.Loc2_Spring_Security.Repository;

import com.example.Loc2_Spring_Security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("""
            SELECT u FROM User u WHERE u.username = :username
            """)
     Optional<User> findUserByUsername(String username);
}
