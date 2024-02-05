package com.dan.StudentDwellMate.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.interfaces.ConnectionRequestsService;
import com.dan.StudentDwellMate.Service.interfaces.ConnectionService;
import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.model.dto.response.ProfilePrivateResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.util.Mapper;

import jakarta.transaction.Transactional;

@Service
public class ConnectionServiceImpl implements ConnectionService {

    @Autowired
    private ConnectionRequestsService connectionRequestsServ;

    @Autowired
    private ProfileService profileServ;

    @Transactional
    @Override
    public void addConnection(Long idProfile, Long idConnectionRequest) {

        var profile = this.profileServ.findById(idProfile);
        var connectionRequest = this.connectionRequestsServ.findById(idConnectionRequest);

        if (!profile.getResquestsConnectionReceived().contains(connectionRequest))
            throw new RuntimeException("Solicitação de conexão não encontrada.");

        profile.getConnections().add(connectionRequest.getSender());
        connectionRequest.getSender().getConnections().add(profile);

        this.profileServ.save(profile);
        this.connectionRequestsServ.removeConnectionRequestSent(connectionRequest.getSender().getId(),
                idConnectionRequest);

    }

    @Override
    public List<ProfilePrivateResponseDto> getAllConnections(Long id) {
        var profile = this.profileServ.findById(id);

        return Mapper.getProfilePrivateDto(profile.getConnections());
    }

    @Override
    public void deleteConnection(Long id, Long idProfileConnected) {
        var profile = this.profileServ.findById(id);
        var profileConnected = this.profileServ.findById(idProfileConnected);

        if (!profile.getConnections().contains(profileConnected))
            throw new RuntimeException("Conexão não encontrada.");

        profile.getConnections().remove(profileConnected);
        profileConnected.getConnections().remove(profile);
        this.profileServ.save(profile);
    }

}
