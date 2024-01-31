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
    @Query(value = "INSERT INTO  blocked(profile_id_fk, blocked_profile_id_fk) VALUES(:idProfile, :idProfileBlock)", nativeQuery = true)
    void blockProfile(Long idProfile, Long idProfileBlock);


    @Modifying
    @Transactional    
    @Query(value = "DELETE FROM blocked WHERE profile_id_fk = :idProfile AND blocked_profile_id_fk = :idProfileBlocked", nativeQuery = true)
    void unblockProfile(Long idProfile, Long idProfileBlocked);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO  connections(profile_id_fk, profile_connected_id_fk) VALUES(:idProfile, :idProfileConnected)", nativeQuery = true)
    void addConnection(Long idProfile, Long idProfileConnected);

}
