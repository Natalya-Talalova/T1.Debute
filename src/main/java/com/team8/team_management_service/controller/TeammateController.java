package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.service.TeammateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams/{team_id}/teammates")
public class TeammateController {

    private final TeammateService teammateService;

    public TeammateController(TeammateService teammateService) {
        this.teammateService = teammateService;
    }

    @GetMapping
    public ResponseEntity<List<TeammateDto>> getAllTeammates(@PathVariable Long team_id) {
        return ResponseEntity.ok(teammateService.findAllByTeamId(team_id));
    }

    @GetMapping("/{teammate_id}")
    public ResponseEntity<TeammateDto> getTeammate(@PathVariable Long team_id, @PathVariable Long teammate_id) {
        return ResponseEntity.ok(teammateService.findById(team_id, teammate_id));
    }

    @PostMapping
    public ResponseEntity<TeammateDto> addTeammate(@PathVariable Long team_id, @RequestBody TeammateDto teammateDto) {
        return ResponseEntity.ok(teammateService.addTeammate(team_id, teammateDto));
    }

    @PutMapping("/{teammate_id}")
    public ResponseEntity<TeammateDto> updateTeammate(@PathVariable Long team_id, @PathVariable Long teammate_id, @RequestBody TeammateDto teammateDto) {
        return ResponseEntity.ok(teammateService.updateTeammate(team_id, teammate_id, teammateDto));
    }

    @PatchMapping("/{teammate_id}")
    public ResponseEntity<TeammateDto> partialUpdateTeammate(@PathVariable Long team_id, @PathVariable Long teammate_id, @RequestBody TeammateDto teammateDto) {
        return ResponseEntity.ok(teammateService.partialUpdateTeammate(team_id, teammate_id, teammateDto));
    }

    @DeleteMapping("/{teammate_id}")
    public ResponseEntity<Void> deleteTeammate(@PathVariable Long team_id, @PathVariable Long teammate_id) {
        teammateService.deleteTeammate(team_id, teammate_id);
        return ResponseEntity.noContent().build();
    }
}
