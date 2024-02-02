package com.dan.StudentDwellMate.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.BlockProfileService;
import com.dan.StudentDwellMate.Service.ProfileService;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.repository.ProfileRepository;
import com.dan.StudentDwellMate.util.Mapper;

@Service
public class BlockProfileServiceImpl implements BlockProfileService {

    @Autowired
    private ProfileService profileServ;

    @Autowired
    private ProfileRepository profileRep;

    @Override
    public void blockProfile(Long idProfile, Long idProfileBlock) {

        Profile profile = this.profileServ.findById(idProfile);
        Profile profileBlocked = this.profileServ.findById(idProfileBlock);

        if (idProfile.compareTo(idProfileBlock) == 0)
            throw new RuntimeException("Você não pode bloquear a si próprio");

        if (profile.getBlocked().contains(profileBlocked))
            throw new RuntimeException("Perfil já bloqueado");

        this.profileRep.blockProfile(idProfile, idProfileBlock);

    }

    @Override
    public void unblockProfile(Long idProfile, Long idProfileBlocked) {

        Optional<Profile> profile = this.profileRep.findById(idProfile);
        Optional<Profile> profileBlocked = this.profileRep.findById(idProfileBlocked);

        if (profile.isEmpty())
            throw new RuntimeException("Perfil não encontrado");

        if (profileBlocked.isEmpty())
            throw new RuntimeException("Perfil bloqueado não encontrado");

        if (idProfile.compareTo(idProfileBlocked) == 0)
            throw new RuntimeException("Você não pode desbloquear a si próprio");

        if (!profile.get().getBlocked().contains(profileBlocked.get()))
            throw new RuntimeException("Este perfil não está na sua lista de bloqueados");

        this.profileRep.unblockProfile(idProfile, idProfileBlocked);
    }

    @Override
    public List<ProfileResponseDto> getAllBlockProfile(Long idProfile) {
        
        var profile = this.profileServ.findById(idProfile);

        return Mapper.getProfileDto(profile.getBlocked());
    }

}
