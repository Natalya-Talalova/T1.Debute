package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.TeammateRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link TeammateRole}
 */
public class TeammateRoleDto implements Serializable {
    private final Long id;
    @Size(message = "Name must be between 2 and 256 characters", min = 2, max = 256)
    @NotBlank
    private final String name;

    public TeammateRoleDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeammateRoleDto entity = (TeammateRoleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ")";
    }
}