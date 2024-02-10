package com.dan.StudentDwellMate.infra.cookie;

import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    
    HttpServletResponse generateCookie(HttpServletResponse response, String token);


}
