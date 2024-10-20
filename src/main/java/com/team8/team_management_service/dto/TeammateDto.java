package com.team8.team_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.team8.team_management_service.entity.Teammate}
 */
public class TeammateDto implements Serializable {

    private final Long id;
    @Size(message = "Имя должно быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String name;

    public TeammateDto(Long id, String name) {
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
        TeammateDto that = (TeammateDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TeammateDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
