package com.dan.StudentDwellMate.Service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;

import com.dan.StudentDwellMate.model.dto.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;

public interface ProfileService {

    void save(ProfileRequestDto profileDto) throws DataIntegrityViolationException;

    boolean existsByEmail(String email);

    List<ProfileResponseDto> getAllProfiles(Long id);

    void blockProfile(Long idProfile, Long idProfileBlock);

    void unblockProfile(Long idProfile, Long idProfileBlocked);

    void addConnectionRequest(Long idProfile, Long idProfileConnection);

    void removeConnectionRequestSent(Long idProfile, Long idProfileConnected);

    List<ProfileResponseDto> getAllConnectionRequestSent(Long idProfile);

    List<ProfileResponseDto> getAllConnectionRequestReceived(Long idProfile);

}
