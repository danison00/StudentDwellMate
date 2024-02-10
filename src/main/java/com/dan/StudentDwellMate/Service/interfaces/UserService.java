package com.dan.StudentDwellMate.Service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService  extends UserDetailsService{
    
    boolean existsByUsername(String username);
}
