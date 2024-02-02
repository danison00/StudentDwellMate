package com.dan.StudentDwellMate.Service;

import java.util.List;

import com.dan.StudentDwellMate.model.dto.response.ConnectionRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;

public interface ConnectionRequestsService {

    void addConnectionRequest(Long idSenderProfile, Long idReceiverProfile);

    void removeConnectionRequestSent(Long idProfile, Long connectionRequestId);

    List<ConnectionRequestDto> getAllConnectionRequestSent(Long idProfile);

    List<ProfileResponseDto> getAllConnectionRequestReceiver(Long idProfile);


}
