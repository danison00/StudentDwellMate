package com.dan.StudentDwellMate.web.controllers.privates;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.Service.interfaces.ConnectionRequestsService;

import jakarta.servlet.http.HttpServletRequest;

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
    public ResponseEntity<?> saveConnectionRequest(@RequestParam("idReceiver") Long idReceiver,
            HttpServletRequest request) {

        Long id = (Long) request.getAttribute("id_profile");

        this.connectionRequestsServ.addConnectionRequest(id, idReceiver);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeConnection(@RequestParam("idConnectionRequest") Long idConnectionRequest,
            HttpServletRequest request) {

        Long id = (Long) request.getAttribute("id_profile");

        this.connectionRequestsServ.removeConnectionRequestSent(id, idConnectionRequest);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/sent")
    public ResponseEntity<?> getConnectionRequestsSent(HttpServletRequest request) {

        Long id = (Long) request.getAttribute("id_profile");

        return ResponseEntity.ok().body(this.connectionRequestsServ.getAllConnectionRequestSent(id));
    }

    @GetMapping("/received")
    public ResponseEntity<?> getConnectionRequestsReceived(HttpServletRequest request) {
        Long id = (Long) request.getAttribute("id_profile");

        return ResponseEntity.ok().body(this.connectionRequestsServ.getAllConnectionRequestReceiver(id));

    }

    @DeleteMapping("/reject")
    public ResponseEntity<?> rejectConnectionRequest(@RequestParam Long idConnectionRequest, HttpServletRequest request) {
        Long id = (Long)request.getAttribute("id_profile");

        this.connectionRequestsServ.rejectConnectionRequest(id, idConnectionRequest);

        return ResponseEntity.ok().build();
    }
}
