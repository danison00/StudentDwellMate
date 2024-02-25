package com.dan.StudentDwellMate.web.controllers.publics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.StudentDwellMate.infra.cookie.CookieService;
import com.dan.StudentDwellMate.infra.tokenJWT.TokenService;
import com.dan.StudentDwellMate.model.dto.request.LoginDto;
import com.dan.StudentDwellMate.model.entities.User;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/public/auth")
public class LogController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenServ;

    @Autowired
    private CookieService cookieService;

    @PostMapping("/login")
    public ResponseEntity<ResponseEntity<HttpStatus>> login(@RequestBody LoginDto login, HttpServletResponse response, HttpServletRequest request) {


        var usernamePassword = new UsernamePasswordAuthenticationToken(login.username(), login.password());


        var auth = this.authManager.authenticate(usernamePassword);

        var token = tokenServ.generateJWT((User) auth.getPrincipal());

        response.addHeader("Authorization", "Bearer " + token);

       response = cookieService.generateCookie(response, token);





        return ResponseEntity.ok().build();

    }
}
