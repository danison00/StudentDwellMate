package com.dan.StudentDwellMate.web.controllers.publics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.model.dto.request.ProfileRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/public/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileServ;

    @PostMapping("/new-profile")
    public ResponseEntity<HttpStatus> newProfile(@RequestBody ProfileRequestDto profile)
            throws DataIntegrityViolationException {

        this.profileServ.save(profile);

        return ResponseEntity.ok().build();
    }

  

}
