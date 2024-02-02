package com.dan.StudentDwellMate.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dan.StudentDwellMate.Service.ProfileService;
import com.dan.StudentDwellMate.model.dto.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.ConnectionRequest;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.repository.ConnectionRequestsRepository;
import com.dan.StudentDwellMate.repository.ProfileRepository;
import com.dan.StudentDwellMate.util.Mapper;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRep;

    @Override
    public void save(ProfileRequestDto profileDto) throws DataIntegrityViolationException {
        this.profileRep.save(Mapper.getProfile(profileDto));
    }

    @Override
    public boolean existsByEmail(String email) {
        return profileRep.existsByEmail(email);
    }

    @Override
    public List<ProfileResponseDto> getAllProfiles(Long id) {

        this.findById(id);

        var profilesDto = Mapper.getProfileDto(this.profileRep.getAllProfiles(id));
        return profilesDto;
    }

    @Override
    public List<ProfileResponseDto> getProfilesFromConnectionRequestsSent(Long idProfile) {

        this.findById(idProfile);        

        return Mapper.getProfileDto(this.profileRep.getProfilesFromConnectionRequestsSent(idProfile));
    }

  

    @Override
    public List<ProfileResponseDto> getProfilesFromConnectionRequestsReceiver(Long idProfile) {
   
        this.findById(idProfile);        

        return Mapper.getProfileDto(this.profileRep.getProfilesFromConnectionRequestsReceiver(idProfile));
    }
    @Override
    public Profile findById(Long id) {
        return this.profileRep.findById(id).orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
    }


}
