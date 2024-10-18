package com.team8.team_management_service.exception;

import com.team8.team_management_service.entity.User;
import jakarta.persistence.EntityNotFoundException;

public class CustomEntityNotFoundException extends EntityNotFoundException {

    private final Class<?> entityClass;
    private final Long id;

    public CustomEntityNotFoundException(Class<User> userClass, Long id) {
        super("Could not find " + userClass.getSimpleName() + " with id " + id);
        this.entityClass = userClass;
        this.id = id;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public Long getId() {
        return id;
    }
}
