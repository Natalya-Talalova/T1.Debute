package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.TeammateRole;

import java.util.List;

public interface TeammateService {

    // Получение участника по идентификатору участника
    TeammateDto findById(Long teammateId);

    // Получение всех участников команды
    List<TeammateDto> findAll(Long teamId);

    // Создание участника в команде
    TeammateDto create(Long teamId, Long userId, TeammateRole role);

    // Обновление участника команды
    // Полное обновление участника команды
    TeammateDto update(Long teammateId, TeammateDto teammateDto);

    // Частичное обновление участника команды
    TeammateDto partialUpdate(Long teammateId, TeammateDto teammateDto);

    // Удаление участника команды
    void delete(Long teammateId);
}