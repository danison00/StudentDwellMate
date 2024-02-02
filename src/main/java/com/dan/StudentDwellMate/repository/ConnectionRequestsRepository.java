package com.dan.StudentDwellMate.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dan.StudentDwellMate.model.entities.ConnectionRequest;
import com.dan.StudentDwellMate.model.entities.Profile;

public interface ConnectionRequestsRepository extends JpaRepository<ConnectionRequest, Long>{
    
    @Query("SELECT cr FROM ConnectionRequest cr WHERE (cr.sender.id = :idSender AND cr.receiver.id = :idReceiver) OR (cr.receiver.id = :idSender AND cr.sender.id = :idReceiver)")
    Optional<ConnectionRequest> connectionRequestAlreadyExists(Long idSender, Long idReceiver);

    @Query("SELECT cr FROM ConnectionRequest cr WHERE cr.sender.id = :idProfile")
    List<ConnectionRequest> getProfilesFromConnectionRequestsSent(Long idProfile);

    @Query("SELECT cr.sender FROM ConnectionRequest cr WHERE cr.receiver.id = :idProfile")
    List<Profile> getProfilesFromConnectionRequestsReceived(Long idProfile);

    void deleteById(Long id);

}
