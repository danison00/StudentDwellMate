package com.dan.StudentDwellMate.infra.security;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.dan.StudentDwellMate.Service.interfaces.ProfileService;
import com.dan.StudentDwellMate.Service.interfaces.UserService;
import com.dan.StudentDwellMate.infra.tokenJWT.TokenService;
import com.dan.StudentDwellMate.model.entities.Profile;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFIlter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileServ;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var token = this.recoverToken(request);


        if (token.isPresent()) {
            var username = tokenService.decodeTokenJWT(token.get()).get();
            UserDetails user = userService.loadUserByUsername(username);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            Long id = this.profileServ.findIdByUsername(username);
            request.setAttribute("id_profile", id);
            
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        filterChain.doFilter(request, response);

    }

    private Optional<String> recoverToken(HttpServletRequest request) {
        var cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token-jwt"))
                   return Optional.of(cookie.getValue());
            }
        }

        return Optional.empty();

    }

}
