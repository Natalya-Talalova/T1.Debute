package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.entity.TeammateRole;
import com.team8.team_management_service.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TeammateRepositoryTest {

    @Autowired
    private TeammateRepository teammateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    private User user;
    private Team team;

    @BeforeEach
    void setUp() {
        // Создаем и сохраняем пользователя
        user = new User();
        user.setPhoneNumber("12345678901");
        user.setAge(30);
        user.setUsername("username");
        user.setPassword("password123");
        user.setName("John");
        user.setLastname("Doe");
        user.setPosition("Developer");
        user.setExperience("5 years of experience");
        user.setMessenger("Telegram");
        user.setSkills("Java, Spring Boot");
        user.setAreaOfResponsibility("Backend development");
        user.setVisibility(true);
        user = userRepository.save(user);

        // Создаем и сохраняем команду
        team = new Team();
        team.setName("Development Team");
        team.setDescription("Handles all development tasks");
        team = teamRepository.save(team);
    }

    @Test
    void shouldSaveTeammateSuccessfully() {
        Teammate teammate = new Teammate();
        teammate.setUser(user);
        teammate.setTeam(team);
        teammate.setRoles(Set.of(TeammateRole.DEVELOPER, TeammateRole.TESTER));

        Teammate savedTeammate = teammateRepository.save(teammate);

        assertThat(savedTeammate.getId()).isNotNull();
        assertThat(savedTeammate.getUser()).isEqualTo(user);
        assertThat(savedTeammate.getTeam()).isEqualTo(team);
        assertThat(savedTeammate.getRoles()).containsExactlyInAnyOrder(TeammateRole.DEVELOPER, TeammateRole.TESTER);
    }


    @Test
    void shouldUpdateTeammateRolesSuccessfully() {
        Teammate teammate = new Teammate();
        teammate.setUser(user);
        teammate.setTeam(team);
        teammate.setRoles(new HashSet<>(Set.of(TeammateRole.DEVELOPER)));
        Teammate savedTeammate = teammateRepository.save(teammate);

        // Обновляем роли с использованием изменяемого HashSet
        savedTeammate.setRoles(new HashSet<>(Set.of(TeammateRole.TESTER, TeammateRole.MANAGER)));
        Teammate updatedTeammate = teammateRepository.save(savedTeammate);

        assertThat(updatedTeammate.getRoles()).containsExactlyInAnyOrder(TeammateRole.TESTER, TeammateRole.MANAGER);
    }

    @Test
    void shouldDeleteTeammateSuccessfully() {
        Teammate teammate = new Teammate();
        teammate.setUser(user);
        teammate.setTeam(team);
        teammate.setRoles(Set.of(TeammateRole.DEVELOPER));
        Teammate savedTeammate = teammateRepository.save(teammate);

        teammateRepository.delete(savedTeammate);

        assertThat(teammateRepository.findById(savedTeammate.getId())).isEmpty();
    }
}
