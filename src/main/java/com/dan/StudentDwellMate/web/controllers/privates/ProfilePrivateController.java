package com.dan.StudentDwellMate.web.controllers.privates;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.model.dto.response.ProfileResponseDto;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/private/my-profile")
public class ProfilePrivateController {

    @Autowired
    private ProfileService profileServ;

    @GetMapping("/all-profiles")
    public ResponseEntity<List<ProfileResponseDto>> getAllProfiles(@RequestParam Long id) {

        return ResponseEntity.ok().body(this.profileServ.getAllProfiles(Long.valueOf(id)));
    }

}
