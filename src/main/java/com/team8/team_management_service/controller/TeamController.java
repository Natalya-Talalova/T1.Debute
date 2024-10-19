package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<TeamDto> update(@RequestBody TeamDto teamDto, @PathVariable Long id) {
        TeamDto updatedTeam = teamService.update(teamDto, id);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @Operation(summary = "Удалить команду по id")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        teamService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Найти команду по id")
    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> findById(@PathVariable Long id) {
        Optional<TeamDto> team = Optional.ofNullable(teamService.findById(id));
        return team.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Найти команду по названию")
    @GetMapping("/{teamName}")
    public ResponseEntity<TeamDto> findByTeamName(@PathVariable String teamName) {
        Optional<TeamDto> team = Optional.ofNullable(teamService.findByTeamName(teamName));
        return team.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Удалить команду по названию")
    @DeleteMapping("/{teamName}")
    public ResponseEntity<HttpStatus> deleteByTeamName(@PathVariable String teamName) {
        teamService.deleteByTeamName(teamName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Получить все команды")
    @GetMapping
    public ResponseEntity<List<TeamDto>> findAll() {
        List<TeamDto> teams = teamService.findAll();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

}
