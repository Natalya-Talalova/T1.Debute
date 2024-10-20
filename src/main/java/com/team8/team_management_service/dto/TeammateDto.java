package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.TeammateRole;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.team8.team_management_service.entity.Teammate}
 */
public class TeammateDto implements Serializable {

    private final Long id;
    @NotNull
    private final Set<TeammateRole> roles;

    public TeammateDto(Long id, Set<TeammateRole> roles) {
        this.id = id;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public Set<TeammateRole> getRoles() {
        return roles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roles);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeammateDto entity = (TeammateDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.roles, entity.roles);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "roles = " + roles + ")";
    }
}