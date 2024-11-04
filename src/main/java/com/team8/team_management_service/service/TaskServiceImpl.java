package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TaskDto;
import com.team8.team_management_service.entity.Task;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.exception.EntityNotFoundByIdException;
import com.team8.team_management_service.mapper.TaskMapper;
import com.team8.team_management_service.repository.TaskRepository;
import com.team8.team_management_service.repository.TeammateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final TeammateRepository teammateRepository;

    @Override
    public List<TaskDto> findAll(Long teammateId) {
        List<Task> tasks = taskRepository.findByTeammateId(teammateId);
        return tasks.stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto findById(Long teammateId, Long taskId) {
        Task task = taskRepository.findByIdAndTeammateId(teammateId, taskId)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class, taskId));
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto create(Long teammateId, TaskDto taskDto) {
        Teammate teammate = teammateRepository.findById(teammateId)
                .orElseThrow(() -> new EntityNotFoundByIdException(Teammate.class, teammateId));
        Task task = taskMapper.toEntity(taskDto);
        task.setTeammate(teammate);
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto update(Long teammateId, TaskDto taskDto, Long taskId) {
        Task existingTask = taskRepository.findByIdAndTeammateId(teammateId, taskId)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class, taskId));
        Task updatedTask = taskMapper.toEntity(taskDto);
        updatedTask.setId(taskId);
        updatedTask.setTeammate(existingTask.getTeammate());
        updatedTask = taskRepository.save(updatedTask);
        return taskMapper.toDto(updatedTask);
    }

    @Override
    public void delete(Long teammateId, Long taskId) {
        Task task = taskRepository.findByIdAndTeammateId(teammateId, taskId)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class, taskId));
        taskRepository.delete(task);
    }

    @Override
    public TaskDto partialUpdate(Long teammateId, TaskDto taskDto, Long taskId) {
        Task existingTask = taskRepository.findByIdAndTeammateId(teammateId, taskId)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class, taskId));
        taskMapper.partialUpdate(taskDto, existingTask);
        existingTask = taskRepository.save(existingTask);
        return taskMapper.toDto(existingTask);
    }
}
