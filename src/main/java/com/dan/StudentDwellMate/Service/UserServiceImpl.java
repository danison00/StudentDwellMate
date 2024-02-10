package com.dan.StudentDwellMate.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.interfaces.UserService;
import com.dan.StudentDwellMate.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository uRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return this.uRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuário inexistente ou senha inválida"));

    }

    @Override
    public boolean existsByUsername(String username){
        return this.uRepository.existsByUsername(username);
    }

}
