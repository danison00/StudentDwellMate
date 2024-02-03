package com.dan.StudentDwellMate.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dan.StudentDwellMate.Service.interfaces.ConnectionRequestsService;
import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.model.dto.response.ConnectionRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.ConnectionRequest;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.repository.ConnectionRequestsRepository;
import com.dan.StudentDwellMate.util.Mapper;

@Service
public class ConnectionRequestsServiceImpl implements ConnectionRequestsService {

    @Autowired
    private ConnectionRequestsRepository connectionRequestsRep;

    @Autowired
    private ProfileService profileServ;

    @Transactional
    @Override
    public void addConnectionRequest(Long idSenderProfile, Long idReceiverProfile) {

        Profile senderProfile = this.profileServ.findById(idSenderProfile);
        Profile receiverProfile = this.profileServ.findById(idReceiverProfile);

        if (idSenderProfile.compareTo(idReceiverProfile) == 0)
            throw new RuntimeException("Você não pode enviar uma solicitação de conexão para si mesmo");

        if (this.connectionRequestsRep.connectionRequestAlreadyExists(idSenderProfile, idReceiverProfile).isPresent()) {
            throw new RuntimeException("Solicitção já realizada");
        }
        var connectionRequest = new ConnectionRequest(senderProfile, receiverProfile);

        senderProfile.getResquestsConnectionSent().add(connectionRequest);
        receiverProfile.getResquestsConnectionReceived().add(connectionRequest);

        this.connectionRequestsRep.save(connectionRequest);

    }

    @Transactional
    @Override
    public void removeConnectionRequestSent(Long idProfile, Long connectionRequestId) {

        var profile = this.profileServ.findById(idProfile);
        var connectionRequest = this.findById(connectionRequestId);

        if (!profile.getResquestsConnectionSent().contains(connectionRequest))
            throw new RuntimeException("Solicitação de conexão não encontrada");

        this.connectionRequestsRep.deleteById(connectionRequestId);

    }

    @Override
    public List<ConnectionRequestDto> getAllConnectionRequestSent(Long idProfile) {

        this.profileServ.findById(idProfile);

        var connectionRequests = this.connectionRequestsRep.getConnectionRequestsSent(idProfile);

        List<ConnectionRequestDto> connectionRequestDtos = new ArrayList<>();

        connectionRequests.forEach((cr) -> {

            var profileDto = Mapper.getProfileDto(cr.getReceiver());

            connectionRequestDtos.add(new ConnectionRequestDto(cr.getId(), profileDto, cr.getDate()));
        });
        return connectionRequestDtos;

    }

    public ConnectionRequest findById(Long id) {
        return this.connectionRequestsRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitação de conexão não encontrada"));
    }

    @Override
    public List<ConnectionRequestDto> getAllConnectionRequestReceiver(Long idProfile) {



        this.profileServ.findById(idProfile);

        var connectionRequests = this.connectionRequestsRep.getConnectionRequestsReceived(idProfile);

        List<ConnectionRequestDto> connectionRequestDtos = new ArrayList<>();

        connectionRequests.forEach((cr) -> {

            var profileDto = Mapper.getProfileDto(cr.getSender());

            connectionRequestDtos.add(new ConnectionRequestDto(cr.getId(), profileDto, cr.getDate()));
        });


        return connectionRequestDtos;
    }

}
