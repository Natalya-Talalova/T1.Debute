package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);
}
