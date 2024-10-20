package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String teamName);

    boolean existsByName(String teamName);

    void deleteByName(String teamName);
}