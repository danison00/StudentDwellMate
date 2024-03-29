package com.dan.StudentDwellMate.infra.cookie;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CookieServiceImpl implements CookieService{

    @Override
    public HttpServletResponse generateCookie(HttpServletResponse response, String token) {
        
        Cookie cookie = new Cookie("token-jwt", token);

        cookie.setHttpOnly(true);
        cookie.setMaxAge(62*2);
        cookie.setPath("/");

        Cookie cookie2 = new Cookie("token-jwt-present", "true");

        cookie2.setMaxAge(62*2);
        cookie2.setPath("/");
        response.addCookie(cookie2);
        response.addCookie(cookie);


        return response;
    }
    
}
