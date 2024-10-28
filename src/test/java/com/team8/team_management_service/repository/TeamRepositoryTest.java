package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.Team;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    private Team validTeam;

    @BeforeEach
    void setUp() {
        validTeam = new Team();
        validTeam.setName("Development Team");
        validTeam.setDescription("Handles all development tasks");
    }

    @Test
    void shouldSaveTeamSuccessfully() {
        Team savedTeam = teamRepository.save(validTeam);

        assertThat(savedTeam.getId()).isNotNull();
        assertThat(savedTeam.getName()).isEqualTo("Development Team");
        assertThat(savedTeam.getDescription()).isEqualTo("Handles all development tasks");
    }

    @Test
    void shouldFailToSaveTeamWithBlankName() {
        validTeam.setName(" "); // Пустое имя

        assertThatThrownBy(() -> teamRepository.saveAndFlush(validTeam))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void shouldFailToSaveTeamWithShortDescription() {
        validTeam.setDescription("A"); // Слишком короткое описание

        assertThatThrownBy(() -> teamRepository.saveAndFlush(validTeam))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void shouldNotAllowDuplicateTeamName() {
        teamRepository.save(validTeam);

        Team duplicateTeam = new Team();
        duplicateTeam.setName("Development Team"); // Дублирующееся имя команды
        duplicateTeam.setDescription("Another description");

        assertThatThrownBy(() -> teamRepository.saveAndFlush(duplicateTeam))
                .isInstanceOf(DataIntegrityViolationException.class); // Исключение из-за уникального ограничения
    }

    @Test
    void testEqualsAndHashCodeWithSameId() {
        Team team1 = new Team();
        team1.setId(1L);
        team1.setName("Development Team");

        Team team2 = new Team();
        team2.setId(1L);
        team2.setName("Design Team");

        assertThat(team1).isEqualTo(team2);
        assertThat(team1.hashCode()).isEqualTo(team2.hashCode());
    }

    @Test
    void shouldDeleteTeamSuccessfully() {
        Team savedTeam = teamRepository.save(validTeam);

        teamRepository.delete(savedTeam);

        assertThat(teamRepository.findById(savedTeam.getId())).isEmpty();
    }

    @Test
    void shouldVerifyEqualsForSameIdInDatabase() {
        // Сохранение команды в базе данных
        Team savedTeam1 = teamRepository.save(validTeam);

        // Загрузка той же команды еще раз из базы данных
        Team fetchedTeam1 = teamRepository.findById(savedTeam1.getId()).orElseThrow();

        // Проверка равенства и хэш-кода
        assertThat(savedTeam1).isEqualTo(fetchedTeam1);
    }

    @Test
    void shouldVerifyEqualsForDifferentIdsInDatabase() {
        // Сохранение двух команд в базе данных
        Team savedTeam1 = teamRepository.save(validTeam);

        Team differentTeam = new Team();
        differentTeam.setName("Design Team");
        differentTeam.setDescription("Handles all design tasks");
        Team savedTeam2 = teamRepository.save(differentTeam);

        // Проверка неравенства и различных хэш-кодов для команд с разными id
        assertThat(savedTeam1).isNotEqualTo(savedTeam2);
    }
}
