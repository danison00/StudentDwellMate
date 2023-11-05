package com.dan.StudentDwellMate.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.AdversementService;
import com.dan.StudentDwellMate.model.dto.AdvertisementDto;
import com.dan.StudentDwellMate.model.entities.Advertisement;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdvertisementController {
    
    @Autowired
    private AdversementService adversementService;

    @PostMapping(value="saveAdversement")
    public ResponseEntity<?> saveAdversement(@RequestBody AdvertisementDto advertisementDto) {
        
       return ResponseEntity.ok().body(this.adversementService.saveAndFlush(advertisement));
    }


    

}
