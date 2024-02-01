package com.dan.StudentDwellMate.web.controllers.privates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dan.StudentDwellMate.Service.ProfileService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/private/my-profile")
public class ProfilePrivateController {

    @Autowired
    private ProfileService profileServ;

    @PostMapping("/block-profile")
    public ResponseEntity<?> blockProfile(@RequestParam("idProfile") Long idProfile,
            @RequestParam("idProfileBlock") Long idProfileBlock) {

        this.profileServ.blockProfile(idProfile, idProfileBlock);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/unblock-profile")
    public ResponseEntity<?> unblockProfile(@RequestParam("idSenderProfile") Long idProfile,
            @RequestParam("idProfileBlocked") Long idProfileBlocked) {

        this.profileServ.unblockProfile(idProfile, idProfileBlocked);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/send-connection-request")
    public ResponseEntity<?> addConnection(@RequestParam("idSenderProfile") Long idSenderProfile,
            @RequestParam("idReceiverProfile") Long idReceiverProfile) {

        this.profileServ.addConnectionRequest(idSenderProfile, idReceiverProfile);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/remove-connection-request")
    public ResponseEntity<?> removeConnection(@RequestParam("idSenderProfile") Long idSenderProfile,
            @RequestParam("idReceiverProfile") Long idReceiverProfile) {

        this.profileServ.removeConnectionRequestSent(idSenderProfile, idReceiverProfile);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/connection-requests-sent")
    public ResponseEntity<?> getConnectionRequestsSent(@RequestParam()Long id) {
        
        
        return ResponseEntity.ok().body(this.profileServ.getAllConnectionRequestSent(id));
    }
    @GetMapping("/connection-requests-received")
    public ResponseEntity<?> getConnectionRequestsReceived(@RequestParam()Long id) {
        
        
        return ResponseEntity.ok().body(this.profileServ.getAllConnectionRequestReceived(id));
    }

}
