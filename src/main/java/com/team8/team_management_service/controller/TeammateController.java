package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.TeammateRole;
import com.team8.team_management_service.service.TeammateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams/{teamId}/teammates")
@AllArgsConstructor
public class TeammateController {

    private final TeammateService teammateService;

    @Operation(summary = "Получить всех участников команды")
    @GetMapping
    public List<TeammateDto> findAll(@PathVariable("teamId") Long teamId) {
        return teammateService.findAll(teamId);
    }

    @Operation(summary = "Получить участника команды по id")
    @GetMapping("/{teammateId}")
    public TeammateDto findById(@PathVariable String teamId, @PathVariable("teammateId") Long teammateId) {
        return teammateService.findById(teammateId);
    }

    @Operation(summary = "Добавить нового участника в команду")
    @PostMapping
    public ResponseEntity<TeammateDto> create(
            @PathVariable("teamId") Long teamId,
            @RequestParam("userId") Long userId,
            @RequestParam("role") TeammateRole role) {
        TeammateDto createdTeammate = teammateService.create(teamId, userId, role);
        return new ResponseEntity<>(createdTeammate, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновить участника команды")
    @PutMapping("/{teammateId}")
    public TeammateDto update(@RequestBody TeammateDto teammateDto, @PathVariable("teammateId") Long teammateId) {
        return teammateService.update(teammateDto, teammateId);
    }

    @Operation(summary = "Частичное обновление участника команды")
    @PatchMapping("/{teammateId}")
    public TeammateDto partialUpdate(@RequestBody TeammateDto teammateDto, @PathVariable("teammateId") Long teammateId) {
        return teammateService.partialUpdate(teammateDto, teammateId);
    }

    @Operation(summary = "Удалить участника команды")
    @DeleteMapping("/{teammateId}")
    public void delete(@PathVariable("teammateId") Long teammateId) {
        teammateService.delete(teammateId);
    }

    @Operation(summary = "Найти все команды пользователя")
    @GetMapping("teams/search?userId")
    public List<Team> findTeamsByUserId(@RequestParam("userId") Long userId) {
        return teammateService.findTeamsByUserId(userId);

    }

    @Operation(summary = "Получить всех пользователей команды")
    @GetMapping("/team/{teamId}/users")
    public List<UserDto> getUsersByTeamId(@PathVariable Long teamId) {
        return teammateService.getUsersByTeamId(teamId);
    }
}
