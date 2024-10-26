package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.entity.TeammateRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeammateService {
    //List<TeammateDto> findAll();

   // TeammateDto findById(Long teamId, Long teammateId);

    TeammateDto findById(Long teamId, Long teammateId);

    // Получение участника по идентификатору участника
    TeammateDto findById(Long teammateId);

    TeammateDto addTeammate(Long teamId, TeammateDto teammateDto);

    TeammateDto addTeammate(Long teamId, UserDto teammateDto);

    // Получение всех участников команды
    List<TeammateDto> findAll(Long teamId);

    // Создание участника в команде
    TeammateDto create(Long teamId, Long userId, TeammateRole role);

    // Частичное обновление участника команды
    TeammateDto partialUpdate(TeammateDto teammateDto, Long teammateId);

    List<Team> findTeamsByUserId(Long userId);

    TeammateDto update(Long teammateId, TeammateDto teammateDto);

    void delete(Long teammateId);
}