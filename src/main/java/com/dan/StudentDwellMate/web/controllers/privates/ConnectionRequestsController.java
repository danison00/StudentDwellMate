package com.dan.StudentDwellMate.web.controllers.privates;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.ConnectionRequestsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@RestController
@RequestMapping("/api/private/connection-requests")
public class ConnectionRequestsController {

    @Autowired
    private ConnectionRequestsService connectionRequestsServ;

    @PostMapping()
    public ResponseEntity<?> saveConnectionRequest(@RequestParam("idSender") Long idSender,
            @RequestParam("idReceiver") Long idReceiver) {

        this.connectionRequestsServ.addConnectionRequest(idSender, idReceiver);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping()
    public ResponseEntity<?> removeConnection(@RequestParam("idProfile") Long idProfile,
            @RequestParam("idConnectionRequest") Long idConnectionRequest) {

        this.connectionRequestsServ.removeConnectionRequestSent(idProfile, idConnectionRequest);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/sent")
    public ResponseEntity<?> getConnectionRequestsSent(@RequestParam() Long id) {

        return ResponseEntity.ok().body(this.connectionRequestsServ.getAllConnectionRequestSent(id));
    }

    @GetMapping("/received")
    public ResponseEntity<?> getConnectionRequestsReceived(@RequestParam() Long id) {

        return ResponseEntity.ok().body(this.connectionRequestsServ.getAllConnectionRequestReceiver(id));

    }
}
