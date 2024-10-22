package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.entity.Team;

import java.util.List;

public interface TeamService {

    TeamDto create(TeamDto teamDto);

    TeamDto partialUpdate(TeamDto teamDto, Long id);

    TeamDto update(TeamDto teamDto, Long id);

    void delete(Long id);

    void deleteByTeamName(String teamName);

    TeamDto findById(Long id);

    TeamDto findByTeamName(String teamName);

    List<TeamDto> findAll();

    TeamDto partialUpdate(Long id, Map<String, Object> fields);

    TeamDto partialUpdate(Long id, TeamDto teamDto);



}
