package com.team8.team_management_service.exception;

import lombok.Getter;

@Getter
public class TeamNameConflictException extends RuntimeException {

    private final String name;

    public TeamNameConflictException(String name) {
        super("Team with name \"" + name + "\" already exists");
        this.name = name;
    }

}
