package com.dan.StudentDwellMate.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.interfaces.BlockProfileService;
import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
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

        Optional<Profile> profile = this.profileRep.findById(idProfile);
        Optional<Profile> profileBlock = this.profileRep.findById(idProfileBlock);

        if (profile.isEmpty())
            throw new RuntimeException("Perfil não encontrado");

        if (profileBlock.isEmpty())
            throw new RuntimeException("Perfil que deseja bloquear não foi encontrado");

        if (idProfile.compareTo(idProfileBlock) == 0)
            throw new RuntimeException("Você não pode bloquear a si próprio");

        if (profile.get().getBlocked().contains(profileBlock.get()))
            throw new RuntimeException("Perfil já bloqueado");

        profile.get().getBlocked().add(profileBlock.get());

        this.profileRep.save(profile.get());
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

        profile.get().getBlocked().remove(profileBlocked.get());

        this.profileRep.save(profile.get());

        // this.profileRep.unblockProfile(idProfile, idProfileBlocked);
    }

    @Override
    public List<ProfileResponseDto> getAllBlockProfile(Long idProfile) {

        var profile = this.profileServ.findById(idProfile);

        return Mapper.getProfileDto(profile.getBlocked());
    }

}
