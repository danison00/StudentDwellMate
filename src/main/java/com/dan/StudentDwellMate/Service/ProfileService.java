package com.dan.StudentDwellMate.Service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.repository.ProfileRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

   
    public Profile save(Profile profile){

        return this.profileRepository.saveAndFlush(profile);
    }
    
}
