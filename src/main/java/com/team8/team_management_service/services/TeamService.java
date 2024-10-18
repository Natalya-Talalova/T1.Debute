package com.team8.team_management_service.services;

import com.team8.team_management_service.dto.TeamDto;
import java.util.List;

public interface TeamService {

    TeamDto create(TeamDto teamDto);

    TeamDto update(TeamDto teamDto, Long id);

    void delete(Long id);

    TeamDto findById(Long id);

    List<TeamDto> findAll();

}
