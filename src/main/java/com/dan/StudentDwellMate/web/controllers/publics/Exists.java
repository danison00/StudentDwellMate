package com.dan.StudentDwellMate.web.controllers.publics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.model.dto.request.ExistsResponseDto;

@RestController
@RequestMapping("api/public/exists")
public class Exists {

    @Autowired
    private ProfileService profileServ;

    @GetMapping("/email")
    public ResponseEntity<ExistsResponseDto> exists(@RequestParam String email) {

        if (this.profileServ.existsByEmail(email))
            return ResponseEntity.ok().body(new ExistsResponseDto("200", "", true));

        return ResponseEntity.ok().body(new ExistsResponseDto("200", "", false));

    }
}
