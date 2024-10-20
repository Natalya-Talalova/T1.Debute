package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
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

    @Operation(summary = "Найти команду по id")
    @GetMapping("/{id}")
    public TeamDto findById(@PathVariable Long id) {
        return teamService.findById(id);
    }

    @Operation(summary = "Получить все команды")
    @GetMapping
    public List<TeamDto> findAll() {
        return teamService.findAll();
    }

//    //TODO: Реализовать эндпоинты
//    @Operation(summary = "Найти команду по названию")
//    @Operation(summary = "Удалить команду по названию")
}
