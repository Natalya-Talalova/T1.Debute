package com.team8.team_management_service.web.security.jwt;

import jakarta.servlet.http.HttpServletRequest;

public class JwtFromRequest {

    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";

    public static String getJwt(HttpServletRequest request) {
        String bearerToken = request.getHeader(AUTHORIZATION);
        if (bearerToken != null && bearerToken.startsWith(BEARER)) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
