package com.team8.team_management_service.repositories;

import com.team8.team_management_service.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}