package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDto> findAll(Long userId);

    TaskDto findById(Long userId, Long id);

    TaskDto create(Long userId, TaskDto taskDto);

    TaskDto update(Long userId, TaskDto taskDto, Long id);

    void delete(Long userId, Long id);

    TaskDto partialUpdate(Long userId, TaskDto taskDto, Long id);
}
