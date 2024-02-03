package com.dan.StudentDwellMate.Service.interfaces;

import java.util.List;

import com.dan.StudentDwellMate.model.dto.response.ProfilePrivateDto;
import com.dan.StudentDwellMate.model.entities.Profile;

public interface ConnectionService {
    
    void addConnection(Long idProfile, Long idConnectionRequest);

    List<ProfilePrivateDto> getAllConnections(Long id);

    void deleteConnection(Long id, Long idProfileConnected);
}
