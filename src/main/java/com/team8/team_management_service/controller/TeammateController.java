package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.TeammateRole;
import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.service.TeammateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams/{teamId}/teammates")
public class TeammateController {

    //TODO: добавить фото профиля команды

    private final TeammateService teammateService;

    public TeammateController(TeammateService teammateService) {
        this.teammateService = teammateService;
    }

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
    public ResponseEntity<TeammateDto> createTeammate(
            @PathVariable("teamId") Long teamId,
            @RequestParam("userId") Long userId,
            @RequestParam("role") TeammateRole role) {
        TeammateDto createdTeammate = teammateService.create(teamId, userId, role);
        return new ResponseEntity<>(createdTeammate, HttpStatus.CREATED);
    }

    @Operation(summary = "Обновить участника команды")
    @PutMapping("/{teammateId}")
    public TeammateDto updateTeammate(@PathVariable("teamId") Long teamId, @RequestBody TeammateDto teammateDto, @PathVariable("teammateId") Long teammateId) {
        return teammateService.update(teammateDto, teammateId);
    }

    @Operation(summary = "Частичное обновление участника команды")
    @PatchMapping("/{teammateId}")
    public TeammateDto partialUpdateTeammate(@PathVariable("teamId") Long teamId, @RequestBody TeammateDto teammateDto, @PathVariable("teammateId") Long teammateId) {
        return teammateService.partialUpdate(teammateDto, teammateId);
    }

    @Operation(summary = "Удалить участника команды")
    @DeleteMapping("/{teammateId}")
    public void deleteTeammate(@PathVariable("teamId") Long teamId, @PathVariable("teammateId") Long teammateId) {
        teammateService.delete(teammateId);
    }

    @Operation(summary = "Найти все команды пользователя")
    @GetMapping("teams/search?userId")
    public List<Team> findTeamsByUserId(@RequestParam("userId") Long userId) {
        return teammateService.findTeamsByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<TeammateDto> addTeammate(@PathVariable("team_id") Long teamId,
                                                   @RequestBody UserDto userDto) {
        return new ResponseEntity<>(teammateService.addTeammate(teamId, userDto), HttpStatus.CREATED);
    }

    @PutMapping("/{teammate_id}")
    public ResponseEntity<TeammateDto> updateTeammate(@PathVariable("team_id") Long teamId,
                                                      @PathVariable("teammate_id") Long teammateId,
                                                      @RequestBody TeammateDto teammateDto) {
        return ResponseEntity.ok(teammateService.updateTeammate(teammateId, teammateDto));
    }

    @PatchMapping("/{teammate_id}")
    public ResponseEntity<TeammateDto> partialUpdateTeammate(@PathVariable("team_id") Long teamId,
                                                             @PathVariable("teammate_id") Long teammateId,
                                                             @RequestBody TeammateDto teammateDto) {
        return ResponseEntity.ok(teammateService.partialUpdateTeammate(teamId, teammateId, teammateDto));
    }

    @DeleteMapping("/{teammate_id}")
    public ResponseEntity<Void> deleteTeammate(@PathVariable("team_id") Long teamId, @PathVariable Long teammate_id) {
        teammateService.deleteTeammate(teamId, teammate_id);
        return ResponseEntity.noContent().build();
    }
}
