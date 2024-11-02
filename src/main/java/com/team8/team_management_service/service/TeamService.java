package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeamDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {

    List<TeamDto> findAll();

    TeamDto findById(Long id);

    TeamDto create(TeamDto teamDto);

    TeamDto update(TeamDto teamDto, Long id);

    TeamDto partialUpdate(TeamDto teamDto, Long id);

    void delete(Long id);

    TeamDto findByTeamName(String teamName);

    void deleteByTeamName(String teamName);
}
