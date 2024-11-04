package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.TaskDto;
import com.team8.team_management_service.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teammates/{teammateId}/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<TaskDto> getAllTasks(@PathVariable Long teammateId) {
        return taskService.findAll(teammateId);
    }

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable Long teammateId, @PathVariable Long taskId) {
        return taskService.findById(teammateId, taskId);
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@PathVariable Long teammateId, @RequestBody TaskDto taskDto) {
        TaskDto createdTask = taskService.create(teammateId, taskDto);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}")
    public TaskDto updateTask(@PathVariable Long teammateId, @PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        return taskService.update(teammateId, taskDto, taskId);
    }

    @PatchMapping("/{taskId}")
    public TaskDto partialUpdateTask(@PathVariable Long teammateId, @PathVariable Long taskId, @RequestBody TaskDto taskDto) {
        return taskService.partialUpdate(teammateId, taskDto, taskId);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long teammateId, @PathVariable Long taskId) {
        taskService.delete(teammateId, taskId);
        return ResponseEntity.noContent().build();
    }
}
