package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Task;
import com.team8.team_management_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);

    Optional<Task> findByIdAndUserId(Long userId, Long id);
}
