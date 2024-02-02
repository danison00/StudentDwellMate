package com.dan.StudentDwellMate.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;

import com.dan.StudentDwellMate.model.dto.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;

public interface ProfileService {

    void save(ProfileRequestDto profileDto) throws DataIntegrityViolationException;

    Profile findById(Long id);

    boolean existsByEmail(String email);

    List<ProfileResponseDto> getAllProfiles(Long id);

    List<ProfileResponseDto> getProfilesFromConnectionRequestsSent(Long idProfile);

    List<ProfileResponseDto> getProfilesFromConnectionRequestsReceiver(Long idProfile);


}
