package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.User;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link User}
 */
public class UserDto implements Serializable {

    private final Long id;

    public UserDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
            "id = " + id + ")";
    }
}