package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.TeammateRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.team8.team_management_service.entity.Teammate}
 */
public class TeammateDto implements Serializable {
    private final Long id;
    @Size(message = "Teammate name must be between 1 and 255 characters", min = 1, max = 255)
    @NotBlank
    private final String name;

    public TeammateDto(Long id, String name, Set<TeammateRole> roles) {
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
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeammateDto entity = (TeammateDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ")";
    }
}