package com.dan.StudentDwellMate.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.ProfileService;
import com.dan.StudentDwellMate.model.dto.ProfileDto;
import com.dan.StudentDwellMate.repository.ProfileRepository;
import com.dan.StudentDwellMate.util.Mapper;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRep;

    @Override
    public void save(ProfileDto profileDto) throws DataIntegrityViolationException
    {
        this.profileRep.save(Mapper.getProfile(profileDto));
    }

    @Override
    public boolean existsByEmail(String email) {
       return profileRep.existsByEmail(email);
    }
    
}
