package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.TeammateRole;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.team8.team_management_service.entity.Teammate}
 */
@Data
@AllArgsConstructor
public class TeammateDto implements Serializable {

    private final Long id;
    @NotNull
    private final Set<TeammateRole> roles;
}