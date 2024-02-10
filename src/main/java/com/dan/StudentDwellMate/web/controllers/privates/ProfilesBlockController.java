package com.dan.StudentDwellMate.web.controllers.privates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.BlockProfileService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/private/block-profiles")
public class ProfilesBlockController {

    @Autowired
    private BlockProfileService blockProfileServ;

    @GetMapping()
    public ResponseEntity<?> findAllProfilesBlock(HttpServletRequest request) {
        Long id = (Long) request.getAttribute("id_profile");

        return ResponseEntity.ok().body(this.blockProfileServ.getAllBlockProfile(id));
    }

    @PostMapping()
    public ResponseEntity<?> blockProfile(@RequestParam Long idProfileBlock, HttpServletRequest request) {
        Long id = (Long) request.getAttribute("id_profile");

        this.blockProfileServ.blockProfile(id, idProfileBlock);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> unblockProfile(@RequestParam Long idProfileBlocked, HttpServletRequest request) {

        Long id = (Long)request.getAttribute("id_profile");

        this.blockProfileServ.unblockProfile(id, idProfileBlocked);

        return ResponseEntity.ok().build();
    }
}
