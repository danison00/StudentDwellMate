package com.dan.StudentDwellMate.web.controllers.privates;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.ConnectionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/private/connection")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;


    @PostMapping("/accept")
    public ResponseEntity<?> accept(@RequestParam Long idProfile,@RequestParam Long idConnectionRequest) {
        
        this.connectionService.addConnection(idProfile, idConnectionRequest);
        
        return ResponseEntity.ok().build();
    }
    
    
}
