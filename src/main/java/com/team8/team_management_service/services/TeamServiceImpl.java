package com.team8.team_management_service.services;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.exception.CustomEntityNotFoundException;
import com.team8.team_management_service.mapper.TeamMapper;
import com.team8.team_management_service.repository.TeamRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public TeamDto create(TeamDto teamDto) {
        Team team = teamMapper.toEntity(teamDto);
        team = teamRepository.save(team);
        return teamMapper.toDto(team);
    }

    @Override
    public TeamDto update(TeamDto teamDto, Long id) {
        Team team = teamRepository.findById(id)
            .orElseThrow(() -> new CustomEntityNotFoundException(Team.class, id));

        team.setName(teamDto.getName());
        team.setDescription(teamDto.getDescription());

        Team updatedTeam = teamRepository.save(team);
        return teamMapper.toDto(updatedTeam);
    }

    @Override
    public void delete(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new CustomEntityNotFoundException(Team.class, id);
        }
        teamRepository.deleteById(id);
    }

    @Override
    public TeamDto findById(Long id) {
        Team team = teamRepository.findById(id)
            .orElseThrow(() -> new CustomEntityNotFoundException(Team.class, id));
        return teamMapper.toDto(team);
    }

    @Override
    public List<TeamDto> findAll() {
        return teamRepository.findAll()
            .stream()
            .map(teamMapper::toDto)
            .toList();
    }
}
