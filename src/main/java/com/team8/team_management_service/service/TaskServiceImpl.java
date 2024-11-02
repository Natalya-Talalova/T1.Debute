package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TaskDto;
import com.team8.team_management_service.entity.Task;
import com.team8.team_management_service.entity.User;
import com.team8.team_management_service.exception.EntityNotFoundByIdException;
import com.team8.team_management_service.mapper.TaskMapper;
import com.team8.team_management_service.repository.TaskRepository;
import com.team8.team_management_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskMapper taskMapper;
    private final TaskRepository taskRepository;
    private final UserRepository userRrepository;


    @Override
    public List<TaskDto> findAll(Long userId) {
        User user = userRrepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundByIdException(User.class, userId));
        return taskRepository.findByUser(user)
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto findById(Long userId, Long id) {
        Task task = taskRepository.findByIdAndUserId(userId, id)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class, id));
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto create(Long userId, TaskDto taskDto) {
        User user = userRrepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundByIdException(User.class, userId));
        Task task = taskMapper.toEntity(taskDto);
        task.setAssignedUser(user);
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto update(Long userId, TaskDto taskDto, Long id) {
        Task existingTask = taskRepository.findByIdAndUserId(userId, id)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class,id));
        Task updatedTask = taskMapper.toEntity(taskDto);
        updatedTask.setId(id);
        updatedTask.setAssignedUser(existingTask.getAssignedUser());
        return taskMapper.toDto(taskRepository.save(updatedTask));
    }

    @Override
    public void delete(Long userId, Long id) {
        Task task = taskRepository.findByIdAndUserId(userId, id)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class, id));
        taskRepository.delete(task);
    }

    @Override
    public TaskDto partialUpdate(Long userId, TaskDto taskDto, Long id) {
        Task existingTask = taskRepository.findByIdAndUserId(userId, id)
                .orElseThrow(() -> new EntityNotFoundByIdException(Task.class, id));
        taskMapper.partialUpdate(taskDto, existingTask);
        return taskMapper.toDto(taskRepository.save(existingTask));
    }
}
