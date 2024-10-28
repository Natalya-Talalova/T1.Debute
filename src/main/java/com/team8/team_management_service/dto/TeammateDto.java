package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.TeammateRole;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

/**
 * DTO for {@link com.team8.team_management_service.entity.Teammate}
 */
@Data
public class TeammateDto {

    private final Long id;
    private final UserDto user;
    private final TeamDto team;
    @NotNull
    private final Set<TeammateRole> roles;
}