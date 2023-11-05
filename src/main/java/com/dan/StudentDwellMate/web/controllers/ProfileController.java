package com.dan.StudentDwellMate.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.model.entities.Profile;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/newProfile")
    public ResponseEntity<?> createProfile(@RequestBody Profile profile){
        
        return ResponseEntity.ok().body(profileService.save(profile));
    }
    
  
}
