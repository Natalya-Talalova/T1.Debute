package com.team8.team_management_service.repository;


import com.team8.team_management_service.entity.Teammate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeammateRepository extends JpaRepository<Teammate, Long> {
}
