package com.team8.team_management_service.web.security.exception.jwt;

public class JwtTokenExpiredException extends RuntimeException {

    private static final String MESSAGE_TEMPLATE = "JWT token has expired: ";

    public JwtTokenExpiredException(String message) {
        super(MESSAGE_TEMPLATE + message);
    }

    public static String getMessage(String message) {
        return MESSAGE_TEMPLATE + message;
    }

}
