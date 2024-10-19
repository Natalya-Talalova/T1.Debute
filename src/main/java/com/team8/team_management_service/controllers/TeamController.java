package com.team8.team_management_service.controllers;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.services.TeamService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<TeamDto> create(@RequestBody TeamDto teamDto) {
        TeamDto createdTeam = teamService.create(teamDto);
        return new ResponseEntity<>(createdTeam, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> update(@RequestBody TeamDto teamDto, @PathVariable Long id) {
        TeamDto updatedTeam = teamService.update(teamDto, id);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
        teamService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> findById(@PathVariable Long id) {
        Optional<TeamDto> team = Optional.ofNullable(teamService.findById(id));
        return team.map(ResponseEntity::ok)
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TeamDto>> findAll() {
        List<TeamDto> teams = teamService.findAll();
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<TeamDto>> findByName(@PathVariable String name) {
        List<TeamDto> teams = teamService.findByName(name);
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<TeamDto> deleteByName(@PathVariable String name) {
        TeamDto deletedTeam = teamService.deleteByName(name);
        return new ResponseEntity<>(deletedTeam, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        TeamDto updatedTeam = teamService.partialUpdate(id, fields);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

}
