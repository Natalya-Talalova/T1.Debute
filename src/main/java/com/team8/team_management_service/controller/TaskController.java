package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TaskDto;
import com.team8.team_management_service.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> findAll(@PathVariable("userId") Long userId) {
        return taskService.findAll(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto create(@PathVariable("userId") Long userId, @RequestBody TaskDto taskDto) {
        return taskService.create(userId, taskDto);
    }

    @PutMapping
    public TaskDto update(@PathVariable("userId") Long userId, @RequestBody TaskDto taskDto, @PathVariable("taskId") Long taskId) {
        return taskService.update(userId, taskDto, taskId);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") Long userId, @PathVariable("taskId") Long taskId) {
        taskService.delete(userId, taskId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{taskId}")
    public TaskDto partialUpdate(@PathVariable("userId") Long userId, @RequestBody TaskDto taskDto, @PathVariable("taskId") Long taskId) {
        return taskService.partialUpdate(userId, taskDto, taskId);
    }

    @GetMapping("/{taskId}")
    public TaskDto findById(@PathVariable("userId") Long userId, @PathVariable("taskId") Long taskId) {
        return taskService.findById(userId, taskId);
    }
}
