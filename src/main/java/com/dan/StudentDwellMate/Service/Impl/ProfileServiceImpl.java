package com.dan.StudentDwellMate.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.ProfileService;
import com.dan.StudentDwellMate.model.dto.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;
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

        var profilesDto = Mapper.getProfileDto(this.profileRep.getAllProfiles(id));
        return profilesDto;
    }

    @Override
    public void blockProfile(Long idProfile, Long idProfileBlock) {

        Optional<Profile> profile = this.profileRep.findById(idProfile);
        Optional<Profile> profileBlocked = this.profileRep.findById(idProfileBlock);

        if (profile.isEmpty())
            throw new RuntimeException("Perfil não encontrado");

        if (profileBlocked.isEmpty())
            throw new RuntimeException("Perfil  que deseja bloquear não foi encontrado");

        if (idProfile.compareTo(idProfileBlock) == 0)
            throw new RuntimeException("Você não pode bloquear a si próprio");

        if (profile.get().getBlocked().contains(profileBlocked.get()))
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

}
