package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.dto.UserDto;

import java.util.List;

public interface TeammateService {

    TeammateDto create(TeammateDto teammateDto);
    List<TeammateDto> findAllByTeamId(Long teamId);

    TeammateDto update(TeammateDto teammate, Long id);
    TeammateDto findById(Long teamId, Long teammateId);

    void delete(Long id);
    TeammateDto addTeammate(Long teamId, TeammateDto teammateDto);

    TeammateDto findById(Long id);

    List<TeammateDto> findAll();
    TeammateDto updateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto);

    TeammateDto partialUpdateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto);

    void deleteTeammate(Long teamId, Long teammateId);
}
