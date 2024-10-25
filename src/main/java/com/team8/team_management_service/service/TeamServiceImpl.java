package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.exception.EntityNotFoundByIdException;
import com.team8.team_management_service.exception.EntityNotFoundByNameException;
import com.team8.team_management_service.exception.TeamNameConflictException;
import com.team8.team_management_service.mapper.TeamMapper;
import com.team8.team_management_service.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public TeamDto create(TeamDto teamDto) {
        if (teamRepository.existsByName(teamDto.getName())) {
            throw new TeamNameConflictException(teamDto.getName());
        }
        Team team = teamMapper.toEntity(teamDto);
        team = teamRepository.save(team);
        return teamMapper.toDto(team);
    }

    @Override
    public TeamDto partialUpdate(TeamDto teamDto, Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new EntityNotFoundByIdException(Team.class, id));
        teamMapper.partialUpdate(teamDto, team);
        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDto(updatedTeam);
    }

    @Override
    public TeamDto update(TeamDto teamDto, Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundByIdException(Team.class, id));
        team.setName(teamDto.getName());
        team.setDescription(teamDto.getDescription());

        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDto(updatedTeam);
    }

    @Override
    public void delete(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new EntityNotFoundByIdException(Team.class, id);
        }
        teamRepository.deleteById(id);
    }

    @Override
    public void deleteByTeamName(String teamName) {
        if (!teamRepository.existsByName(teamName)) {
            throw new EntityNotFoundByNameException(Team.class, teamName);
        }
        teamRepository.deleteByName(teamName);
    }

    @Override
    public TeamDto findById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundByIdException(Team.class, id));
        return teamMapper.toDto(team);
    }

    @Override
    public List<TeamDto> findAll() {
        return teamRepository.findAll()
            .stream()
            .map(teamMapper::toDto)
            .toList();
    }

    @Override
    public TeamDto findByTeamName(String teamName) {
        Team team = teamRepository.findByName(teamName)
                .orElseThrow(() -> new EntityNotFoundByNameException(Team.class, teamName));
        return teamMapper.toDto(team);
    }
}
