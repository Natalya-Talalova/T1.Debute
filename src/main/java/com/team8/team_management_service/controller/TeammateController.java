package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.service.TeammateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams/{teamId}/teammates")
public class TeammateController {

    TeammateService teammateService;

    public TeammateController(TeammateService teammateService) {
        this.teammateService = teammateService;
    }

    @GetMapping
    public ResponseEntity<List<TeammateDto>> findAll(@PathVariable("teamId") Long teamId) {
        List<TeammateDto> teammates = teammateService.findAll();
        return new ResponseEntity<>(teammates, HttpStatus.OK);
    }

}
