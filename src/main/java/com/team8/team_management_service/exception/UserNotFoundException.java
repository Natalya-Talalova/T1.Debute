package com.team8.team_management_service.exception;

import jakarta.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    String email;

    public UserNotFoundException(String email) {
        super("User with email \"" + email + "\" not found");
        this.email = email;
    }
}
