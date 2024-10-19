package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

     List<Team> findByName(String name);

}