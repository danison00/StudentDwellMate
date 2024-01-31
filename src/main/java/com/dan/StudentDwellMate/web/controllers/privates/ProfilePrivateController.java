package com.dan.StudentDwellMate.web.controllers.privates;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.repository.ProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("api/private/my-profile")
public class ProfilePrivateController {

    @Autowired
    private ProfileRepository profileRep;

    @PostMapping("/block-profile")
    public ResponseEntity<?> blockProfile(@RequestParam("idProfile")Long idProfile, @RequestParam("idProfileBlock")Long idProfileBlock) {
        
        this.profileRep.blockProfile(idProfile, idProfileBlock);
        
        return ResponseEntity.ok().build();
    }

    @PostMapping("/unblock-profile")
    public ResponseEntity<?> unblockProfile(@RequestParam("idProfile")Long idProfile, @RequestParam("idProfileBlocked")Long idProfileBlocked) {
        
        this.profileRep.unblockProfile(idProfile, idProfileBlocked);
        
        return ResponseEntity.ok().build();
    }
    
    
}
