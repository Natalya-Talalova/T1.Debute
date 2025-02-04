package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByName(String teamName);

    boolean existsByName(String teamName);

    void deleteByName(String teamName);

    @Query("""
                SELECT t FROM User u
                LEFT JOIN u.teammates tm
                LEFT JOIN tm.team t
                WHERE u.id = :userId
            """)
    List<Team> findTeamsByUserId(@Param("userId") Long userId);
}