package com.team8.team_management_service.repository;


import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface TeammateRepository extends JpaRepository<Teammate, Long> {

    List<Teammate> findByTeamId(Long teamId);

    List<Teammate> findByUserId(Long userId);
}
