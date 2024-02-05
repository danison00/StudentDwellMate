package com.dan.StudentDwellMate.Service.interfaces;

import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;

import com.dan.StudentDwellMate.model.dto.request.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;
public interface ProfileService {

    void save(ProfileRequestDto profileDto) throws DataIntegrityViolationException;

    void save(Profile profile);

    Profile findById(Long id);

    boolean existsByEmail(String email);

    List<ProfileResponseDto> getAllProfiles(Long id);

    boolean existsByUsername(String username);


}
