package com.team8.team_management_service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.team8.team_management_service.entity.Team}
 */
public class TeamDto implements Serializable {

    private final Long id;
    private final String name;
    private final String description;

    public TeamDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TeamDto entity = (TeamDto) o;
        return Objects.equals(this.id, entity.id) &&
            Objects.equals(this.name, entity.name) &&
            Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ", " +
            "name = " + name + ", " +
            "description = " + description + ")";
    }
}