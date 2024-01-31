package com.dan.StudentDwellMate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dan.StudentDwellMate.model.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByEmail(String email);


    // @Query("SELECT p FROM Profile p WHERE p.blocked NOT IN (SELECT profile FROM Profile profile WHERE profile.wantsToSharedProperty = true)")
    @Query("SELECT p FROM Profile p WHERE p NOT IN(SELECT p FROM Profile p WHERE p.id = :id) AND p NOT IN(SELECT p.blocked FROM Profile p WHERE p.id = :id)")
    List<Profile> getAllProfiles(Long id);
}
