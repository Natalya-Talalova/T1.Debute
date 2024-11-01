package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teams")
@AllArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @Operation(summary = "Получить все команды")
    @GetMapping
    public List<TeamDto> findAll() {
        return teamService.findAll();
    }

    @Operation(summary = "Найти команду по id")
    @GetMapping("/{id}")
    public TeamDto findById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @Operation(summary = "Создать команду")
    @PostMapping
    public ResponseEntity<TeamDto> create(@RequestBody TeamDto teamDto) {
        TeamDto createdTeam = teamService.create(teamDto);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @Operation(summary = "Изменить команду")
    @PutMapping("/{id}")
    public TeamDto update(@RequestBody TeamDto teamDto, @PathVariable Long id) {
        return teamService.update(teamDto, id);
    }

    @Operation(summary = "Изменить частично команду")
    @PatchMapping("/{id}")
    public TeamDto partialUpdate(@RequestBody TeamDto teamDto, @PathVariable Long id) {
        return teamService.partialUpdate(teamDto, id);
    }

    @Operation(summary = "Удалить команду по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        teamService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Получить команду по названию")
    @GetMapping("/search")
    public TeamDto findByTeamName(@RequestParam(name = "name") String teamName) {
        return teamService.findByTeamName(teamName);
    }

    @Operation(summary = "Удалить команду по названию")
    @DeleteMapping("/search")
    public ResponseEntity<HttpStatus> deleteByTeamName(@RequestParam(name = "n  ame") String teamName) {
        teamService.deleteByTeamName(teamName);
        return ResponseEntity.noContent().build();
    }

/*    @Operation(summary = "Найти все команды пользователя")
    @GetMapping("teams/search?userId")
    public List<TeamDto> findTeamsByUserId(@RequestParam("userId") Long userId) {
        return teamService.findTeamsByUserId(userId);
    }*/
}
