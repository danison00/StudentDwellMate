package com.dan.StudentDwellMate.Service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.dan.StudentDwellMate.model.dto.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;

public interface ProfileService {
    
    void save(ProfileRequestDto profileDto) throws DataIntegrityViolationException;

    boolean existsByEmail(String email);

    List<ProfileResponseDto> getAllProfiles(Long id);
}
