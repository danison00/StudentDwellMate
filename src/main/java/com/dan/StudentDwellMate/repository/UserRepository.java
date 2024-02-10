package com.dan.StudentDwellMate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.dan.StudentDwellMate.model.entities.User;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<UserDetails> findByUsername(String username);

    boolean existsByUsername(String username);

}
