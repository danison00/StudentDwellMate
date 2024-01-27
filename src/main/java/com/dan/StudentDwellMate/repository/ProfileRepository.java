package com.dan.StudentDwellMate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dan.StudentDwellMate.model.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
