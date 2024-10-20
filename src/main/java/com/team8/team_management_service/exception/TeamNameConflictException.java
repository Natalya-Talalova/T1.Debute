package com.team8.team_management_service.exception;

public class TeamNameConflictException extends RuntimeException {

    private final String name;

    public TeamNameConflictException(String name) {
        super("Team with name \"" + name + "\" already exists");
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
