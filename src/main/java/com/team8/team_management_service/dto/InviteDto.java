package com.team8.team_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.team8.team_management_service.entity.Invite}
 */
@Data
public class InviteDto {
    private final Long id;
    private final String token;
    private final Long teamId;
    private final LocalDateTime expiresAt;
}
