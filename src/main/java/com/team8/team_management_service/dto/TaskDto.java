package com.team8.team_management_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.team8.team_management_service.entity.Task}
 */
@AllArgsConstructor
@Data
@Getter
public class TaskDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
    private Long assignedUserId;
    private Long teamId;
    private String status;
    private String priority;
}
