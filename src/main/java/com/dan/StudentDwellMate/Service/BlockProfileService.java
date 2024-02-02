package com.dan.StudentDwellMate.Service;

import java.util.List;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
public interface BlockProfileService {

    void blockProfile(Long idProfile, Long idProfileBlock);
   
    void unblockProfile(Long idProfile, Long idProfileBlock);
    
    List<ProfileResponseDto> getAllBlockProfile(Long idProfile);



}
