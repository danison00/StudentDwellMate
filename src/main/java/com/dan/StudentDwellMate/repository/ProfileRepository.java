package com.dan.StudentDwellMate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.dan.StudentDwellMate.model.entities.Profile;

import jakarta.transaction.Transactional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByEmail(String email);

    @Query("SELECT p FROM Profile p WHERE p.wantsToSharedProperty = true AND p.id <> :id AND p NOT IN(SELECT bk FROM Profile p JOIN p.blocked bk WHERE p.id = :id)")
    List<Profile> getAllProfiles(Long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO  blocked(id_fk_profile, id_fk_blocked_profile) VALUES(:idProfile, :idProfileBlock)", nativeQuery = true)
    void blockProfile(Long idProfile, Long idProfileBlock);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM blocked WHERE id_fk_profile = :idProfile AND id_fk_blocked_profile = :idProfileBlocked", nativeQuery = true)
    void unblockProfile(Long idProfile, Long idProfileBlocked);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO connection_requests(id_fk_sender_profile, id_fk_receiver_profile) VALUES(:idSenderProfile, :idReceiverProfile)", nativeQuery = true)
    void addRequestConnection(Long idSenderProfile, Long idReceiverProfile);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM connection_requests WHERE id_fk_sender_profile = :idSenderProfile AND id_fk_receiver_profile = :idReceiverProfile", nativeQuery = true)
    void removeConnectionRequest(Long idSenderProfile, Long idReceiverProfile);

    @Query(value = "SELECT * FROM connection_requests cr JOIN profile p ON p.id = cr.id_fk_sender_profile WHERE cr.id_fk_receiver_profile = :id", nativeQuery = true)
    List<Profile> getAllConnectionRequetsReceived(Long id);

    @Query(value = "SELECT profile.* FROM profile " +
            "JOIN connection_request ON profile.id = connection_request.id_fk_profile_receiver" +
            " where connection_request.id_fk_profile_sender =:idProfile", nativeQuery = true)
    List<Profile> getProfilesFromConnectionRequestsSent(Long idProfile);

    @Query(value = "SELECT profile.* FROM profile " +
            "JOIN connection_request ON profile.id = connection_request.id_fk_profile_sender" +
            " where connection_request.id_fk_profile_receiver =:idProfile", nativeQuery = true)
    List<Profile> getProfilesFromConnectionRequestsReceiver(Long idProfile);
}
