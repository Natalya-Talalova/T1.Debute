package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.TeamStatus;
import com.team8.team_management_service.entity.TeamType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.team8.team_management_service.entity.Team}
 */
@Data
public class TeamDto implements Serializable {

    private final Long id;
    @Size(message = "Name must be between 2 and 256 characters", min = 2, max = 256)
    @NotBlank
    private final String name;
    @Size(message = "Description must be between 2 and 256 characters", min = 2, max = 256)
         @NotBlank
    private final String description;
    @NotBlank
    private final TeamStatus status;
    @NotBlank
    private final TeamType type;
    private final String image;
}