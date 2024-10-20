package com.team8.team_management_service.exception;

public class TeamNameConflictException extends RuntimeException {

    private final String name;

    public TeamNameConflictException(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
