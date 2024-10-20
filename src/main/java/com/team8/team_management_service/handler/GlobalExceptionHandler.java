package com.team8.team_management_service.handler;

import com.team8.team_management_service.exception.EntityNotFoundByNameException;
import com.team8.team_management_service.exception.TeamNameConflictException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundByNameException.class)
    public ResponseEntity<String> handleException(EntityNotFoundByNameException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team with name \"" + ex.getName() + "\" not found");
    }

    @ExceptionHandler(TeamNameConflictException.class)
    public ResponseEntity<String> handleException(TeamNameConflictException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Team with name \"" + ex.getName() + "\" already exists");
    }

}
