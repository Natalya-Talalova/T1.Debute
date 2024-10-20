package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.service.TeammateService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams/{team_id}/teammates")
public class TeammateController {

    private final TeammateService teammateService;

    public TeammateController(TeammateService teammateService) {
        this.teammateService = teammateService;
    }

    @Operation(summary = "Получить всех участников команды")
    @GetMapping
    public List<TeammateDto> findAll(@PathVariable("team_id") Long teamId) {
        return teammateService.findAll(teamId);
    }

    @Operation(summary = "Получить участника команды по id")
    @GetMapping("/{teammate_id}")
    public TeammateDto findById(@PathVariable String team_id, @PathVariable("teammate_id") Long teammateId) {
        return teammateService.findById(teammateId);
    }

//    @PostMapping
//    public ResponseEntity<TeammateDto> addTeammate(@PathVariable("team_id") Long teamId,
//                                                   @RequestBody UserDto userDto) {
//        return new ResponseEntity<>(teammateService.addTeammate(teamId, userDto), HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{teammate_id}")
//    public ResponseEntity<TeammateDto> updateTeammate(@PathVariable("team_id") Long teamId,
//                                                      @PathVariable("teammate_id") Long teammateId,
//                                                      @RequestBody TeammateDto teammateDto) {
//        return ResponseEntity.ok(teammateService.updateTeammate(teammateId, teammateDto));
//    }
//
//    @PatchMapping("/{teammate_id}")
//    public ResponseEntity<TeammateDto> partialUpdateTeammate(@PathVariable("team_id") Long teamId,
//                                                             @PathVariable("teammate_id") Long teammateId,
//                                                             @RequestBody TeammateDto teammateDto) {
//        return ResponseEntity.ok(teammateService.partialUpdateTeammate(teamId, teammateId, teammateDto));
//    }
//
//    @DeleteMapping("/{teammate_id}")
//    public ResponseEntity<Void> deleteTeammate(@PathVariable("team_id") Long teamId, @PathVariable Long teammate_id) {
//        teammateService.deleteTeammate(teamId, teammate_id);
//        return ResponseEntity.noContent().build();
//    }
}
