package com.dan.StudentDwellMate.Service;

import org.springframework.dao.DataIntegrityViolationException;

import com.dan.StudentDwellMate.model.dto.ProfileDto;

public interface ProfileService {
    
    void save(ProfileDto profileDto) throws DataIntegrityViolationException;

    boolean existsByEmail(String email);
}
