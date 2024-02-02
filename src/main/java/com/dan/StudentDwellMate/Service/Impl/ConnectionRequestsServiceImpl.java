package com.dan.StudentDwellMate.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dan.StudentDwellMate.Service.ConnectionRequestsService;
import com.dan.StudentDwellMate.Service.ProfileService;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.ConnectionRequest;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.repository.ConnectionRequestsRepository;

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

        System.out.println(connectionRequest.getReceiver().getEmail());
        System.out.println(connectionRequest.getSender().getEmail());
        System.out.println(connectionRequest.getDate());

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
    public List<ProfileResponseDto> getAllConnectionRequestSent(Long idProfile) {

        return this.profileServ.getProfilesFromConnectionRequestsSent(idProfile);

    }


    public ConnectionRequest findById(Long id) {
        return this.connectionRequestsRep.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitação de conexão não encontrada"));
    }

    @Override
    public List<ProfileResponseDto> getAllConnectionRequestReceiver(Long idProfile) {
       
        return this.profileServ.getProfilesFromConnectionRequestsReceiver(idProfile);
    }

}
