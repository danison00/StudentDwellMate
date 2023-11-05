package com.dan.StudentDwellMate.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    @Override
    public Profile save(Profile profile){

        return this.profileRepository.saveAndFlush(profile);
    }
    
}
