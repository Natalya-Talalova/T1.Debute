package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDto> findAll(Long teammateId);

    TaskDto findById(Long teammateId, Long id);

    TaskDto create(Long teammateId, TaskDto taskDto);

    TaskDto update(Long teammateId, TaskDto taskDto, Long id);

    void delete(Long teammateId, Long id);

    TaskDto partialUpdate(Long teammateId, TaskDto taskDto, Long id);
}
