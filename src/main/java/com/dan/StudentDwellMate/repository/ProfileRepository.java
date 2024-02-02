package com.dan.StudentDwellMate.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.dan.StudentDwellMate.model.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

        boolean existsByEmail(String email);

        @Query("SELECT p FROM Profile p WHERE p.wantsToSharedProperty = true AND p.id <> :id AND p NOT IN(SELECT bk FROM Profile p JOIN p.blocked bk WHERE p.id = :id)")
        List<Profile> getAllProfiles(Long id);

}
