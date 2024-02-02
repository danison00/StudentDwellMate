package com.dan.StudentDwellMate.web.controllers.privates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.BlockProfileService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/private/block-profiles")
public class ProfilesBlockController {

    @Autowired
    private BlockProfileService blockProfileServ;

    @GetMapping()
    public ResponseEntity<?> findAllProfilesBlock(@RequestParam("id") Long id) {


        return ResponseEntity.ok().body(this.blockProfileServ.getAllBlockProfile(id));
    }

    @PostMapping()
    public ResponseEntity<?> blockProfile(@RequestParam("idProfile") Long idProfile,
            @RequestParam("idProfileBlock") Long idProfileBlock) {

        this.blockProfileServ.blockProfile(idProfile, idProfileBlock);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> unblockProfile(@RequestParam("idProfile") Long idProfile,
            @RequestParam("idProfileBlocked") Long idProfileBlocked) {

        this.blockProfileServ.unblockProfile(idProfile, idProfileBlocked);

        return ResponseEntity.ok().build();
    }
}
