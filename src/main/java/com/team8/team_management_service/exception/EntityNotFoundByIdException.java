package com.team8.team_management_service.exception;

import jakarta.persistence.EntityNotFoundException;

public class EntityNotFoundByIdException extends EntityNotFoundException {

    private final Class<?> entityClass;
    private final Long id;

    public EntityNotFoundByIdException(Class<?> tClass, Long id) {
        super("Could not find " + tClass.getSimpleName() + " with id: " + id);
        this.entityClass = tClass;
        this.id = id;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public Long getId() {
        return id;
    }
}
