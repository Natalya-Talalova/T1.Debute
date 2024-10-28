package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.TeammateRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeammateService {

    List<TeammateDto> findAll(Long teamId);

    TeammateDto create(Long teamId, Long userId, TeammateRole role);

    TeammateDto findById(Long teammateId);

    TeammateDto update(TeammateDto teammateDto, Long teammateId);

    TeammateDto partialUpdate(TeammateDto teammateDto, Long teammateId);

    void delete(Long teammateId);

    List<Team> findTeamsByUserId(Long userId);
}