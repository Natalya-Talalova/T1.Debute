package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.entity.TeammateRole;
import com.team8.team_management_service.exception.EntityNotFoundByIdException;
import com.team8.team_management_service.mapper.TeammateMapper;
import com.team8.team_management_service.repository.TeammateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TeammateServiceImplTest {

    @Mock
    private TeammateRepository teammateRepository;

    @Mock
    private TeammateMapper teammateMapper;

    @InjectMocks
    private TeammateServiceImpl teammateService;

    @Test
    void shouldFindAllTeammates() {
        Long teamId = 1L;
        Teammate teammate = new Teammate();
        teammate.setId(1L);
        TeammateDto teammateDto = new TeammateDto(1L, Set.of(TeammateRole.DEVELOPER));

        when(teammateRepository.findAll()).thenReturn(List.of(teammate));
        when(teammateMapper.toDto(teammate)).thenReturn(teammateDto);

        List<TeammateDto> result = teammateService.findAll(teamId);

        assertThat(result).containsExactly(teammateDto);
        verify(teammateRepository).findAll();
        verify(teammateMapper).toDto(teammate);
    }

    @Test
    void shouldPartialUpdateTeammate() {
        Long teammateId = 1L;
        Teammate existingTeammate = new Teammate();
        existingTeammate.setId(teammateId);

        TeammateDto partialUpdateDto = new TeammateDto(teammateId, Set.of(TeammateRole.TESTER));
        Teammate updatedTeammate = new Teammate();
        updatedTeammate.setId(teammateId);
        updatedTeammate.setRoles(Set.of(TeammateRole.TESTER));

        when(teammateRepository.findById(teammateId)).thenReturn(Optional.of(existingTeammate));
        when(teammateMapper.partialUpdate(partialUpdateDto, existingTeammate)).thenReturn(updatedTeammate);
        when(teammateRepository.save(updatedTeammate)).thenReturn(updatedTeammate);
        when(teammateMapper.toDto(updatedTeammate)).thenReturn(partialUpdateDto);

        TeammateDto result = teammateService.partialUpdate(partialUpdateDto, teammateId);

        assertThat(result).isEqualTo(partialUpdateDto);
        verify(teammateRepository).findById(teammateId);
        verify(teammateMapper).partialUpdate(partialUpdateDto, existingTeammate);
        verify(teammateRepository).save(updatedTeammate);
        verify(teammateMapper).toDto(updatedTeammate);
    }

    @Test
    void shouldThrowExceptionWhenTeammateNotFoundForPartialUpdate() {
        Long teammateId = 1L;
        TeammateDto updateDto = new TeammateDto(teammateId, Set.of(TeammateRole.DEVELOPER));

        when(teammateRepository.findById(teammateId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> teammateService.partialUpdate(updateDto, teammateId))
                .isInstanceOf(EntityNotFoundByIdException.class);

        verify(teammateRepository).findById(teammateId);
        verifyNoMoreInteractions(teammateRepository, teammateMapper);
    }

    @Test
    void shouldUpdateTeammate() {
        Long teammateId = 1L;
        Teammate existingTeammate = new Teammate();
        existingTeammate.setId(teammateId);

        TeammateDto updateDto = new TeammateDto(teammateId, Set.of(TeammateRole.MANAGER));
        Teammate updatedTeammate = new Teammate();
        updatedTeammate.setId(teammateId);
        updatedTeammate.setRoles(Set.of(TeammateRole.MANAGER));

        when(teammateRepository.findById(teammateId)).thenReturn(Optional.of(existingTeammate));
        when(teammateMapper.toEntity(updateDto)).thenReturn(updatedTeammate);
        when(teammateRepository.save(updatedTeammate)).thenReturn(updatedTeammate);
        when(teammateMapper.toDto(updatedTeammate)).thenReturn(updateDto);

        TeammateDto result = teammateService.update(updateDto, teammateId);

        assertThat(result).isEqualTo(updateDto);
        verify(teammateRepository).findById(teammateId);
        verify(teammateMapper).toEntity(updateDto);
        verify(teammateRepository).save(updatedTeammate);
        verify(teammateMapper).toDto(updatedTeammate);
    }

    @Test
    void shouldFindTeamsByUserId() {
        Long userId = 1L;
        Team team = new Team();
        team.setId(1L);
        Teammate teammate = new Teammate();
        teammate.setTeam(team);

        when(teammateRepository.findByUserId(userId)).thenReturn(List.of(teammate));

        List<Team> result = teammateService.findTeamsByUserId(userId);

        assertThat(result).containsExactly(team);
        verify(teammateRepository).findByUserId(userId);
    }

    @Test
    void shouldThrowExceptionWhenTeammateNotFoundForUpdate() {
        Long teammateId = 1L;
        TeammateDto updateDto = new TeammateDto(teammateId, Set.of(TeammateRole.DEVELOPER));

        when(teammateRepository.findById(teammateId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> teammateService.update(updateDto, teammateId))
                .isInstanceOf(EntityNotFoundByIdException.class);

        verify(teammateRepository).findById(teammateId);
        verifyNoMoreInteractions(teammateRepository, teammateMapper);
    }
}
