package com.dan.StudentDwellMate.Service.interfaces;

import java.util.List;

import com.dan.StudentDwellMate.model.dto.response.ConnectionRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.ConnectionRequest;

public interface ConnectionRequestsService {

    void addConnectionRequest(Long idSenderProfile, Long idReceiverProfile);

    void removeConnectionRequestSent(Long idProfile, Long connectionRequestId);

    List<ConnectionRequestDto> getAllConnectionRequestSent(Long idProfile);

    List<ConnectionRequestDto> getAllConnectionRequestReceiver(Long idProfile);

    void rejectConnectionRequest(Long idProfile, Long idConnectionRequest);

    ConnectionRequest findById(Long id);

}
