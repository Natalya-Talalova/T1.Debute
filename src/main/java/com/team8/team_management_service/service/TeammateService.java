package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.dto.UserDto;

import java.util.List;

public interface TeammateService {

    List<TeammateDto> findAllByTeamId(Long teamId);

    TeammateDto findById(Long teamId, Long teammateId);

    TeammateDto addTeammate(Long teamId, TeammateDto teammateDto);

    TeammateDto updateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto);

    TeammateDto partialUpdateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto);

    void deleteTeammate(Long teamId, Long teammateId);
}
