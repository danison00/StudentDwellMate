package com.dan.StudentDwellMate.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.Service.interfaces.UserService;
import com.dan.StudentDwellMate.model.dto.request.ProfileRequestDto;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import com.dan.StudentDwellMate.model.entities.Profile;
import com.dan.StudentDwellMate.repository.ProfileRepository;
import com.dan.StudentDwellMate.util.Mapper;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRep;

    @Autowired
    private UserService userService;

    @Override
    public void save(ProfileRequestDto profileDto) throws DataIntegrityViolationException {

        if(this.userService.existsByUsername(profileDto.user().username()))
        throw new RuntimeException("Username indisponível.");

        if(this.existsByEmail(profileDto.email()))
        throw new RuntimeException("Email já em uso.");

        var profile = Mapper.getProfile(profileDto);
        profile.getUser().setPassword(new BCryptPasswordEncoder().encode(profile.getUser().getPassword()));

        this.profileRep.save(profile);
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
    public Profile findById(Long id) {
        return this.profileRep.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @Override
    public void save(Profile profile) {
        this.profileRep.save(profile);
    }

    @Override
    public boolean existsByUsername(String username) {
        return profileRep.existsByUserUsername(username);
    }

    @Override
    public Long findIdByUsername(String username) {
        return this.profileRep.findIdByUserUsername(username);
    }

}
