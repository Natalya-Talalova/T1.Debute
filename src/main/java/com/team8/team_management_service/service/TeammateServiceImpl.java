package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.mapper.TeammateMapper;
import com.team8.team_management_service.repository.TeammateRepository;

import java.util.List;

public class TeammateServiceImpl implements TeammateService {

    private final TeammateMapper teammateMapper;
    private final TeammateRepository teammateRepository;

    public TeammateServiceImpl(TeammateMapper teammateMapper, TeammateRepository teammateRepository) {
        this.teammateMapper = teammateMapper;
        this.teammateRepository = teammateRepository;
    }

    @Override
    public List<TeammateDto> findAllByTeamId(Long teamId) {
        return teammateMapper.toDtoList(teammateRepository.findByTeamId(teamId));
    }

    @Override
    public TeammateDto findById(Long teamId, Long teammateId) {
        Teammate teammate = teammateRepository.findById(teammateId)
                .orElseThrow(() -> new CustomEntityNotFoundException(Teammate.class, teammateId));
        if (!teammate.getTeam().getId().equals(teamId)) {
            throw new IllegalArgumentException("Teammate does not belong to this team");
        }
        return teammateMapper.toDto(teammate);
    }

    @Override
    public TeammateDto addTeammate(Long teamId, TeammateDto teammateDto) {
        Teammate teammate = teammateMapper.toEntity(teammateDto);
        teammate.getTeam().setId(teamId); // Устанавливаем ID команды
        teammate = teammateRepository.save(teammate);
        return teammateMapper.toDto(teammate);
    }

    @Override
    public TeammateDto updateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto) {
        Teammate existingTeammate = teammateRepository.findById(teammateId)
                .orElseThrow(() -> new CustomEntityNotFoundException(Teammate.class, teammateId));
        if (!existingTeammate.getTeam().getId().equals(teamId)) {
            throw new IllegalArgumentException("Teammate does not belong to this team");
        }
        Teammate updatedTeammate = teammateMapper.toEntity(teammateDto);
        updatedTeammate.setId(teammateId);
        updatedTeammate.getTeam().setId(teamId);
        return teammateMapper.toDto(teammateRepository.save(updatedTeammate));
    }

    @Override
    public TeammateDto partialUpdateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto) {
        Teammate existingTeammate = teammateRepository.findById(teammateId)
                .orElseThrow(() -> new CustomEntityNotFoundException(Teammate.class, teammateId));
        if (!existingTeammate.getTeam().getId().equals(teamId)) {
            throw new IllegalArgumentException("Teammate does not belong to this team");
        }
        teammateMapper.partialUpdate(teammateDto, existingTeammate);
        return teammateMapper.toDto(teammateRepository.save(existingTeammate));
    }

    @Override
    public void deleteTeammate(Long teamId, Long teammateId) {
        Teammate teammate = teammateRepository.findById(teammateId)
                .orElseThrow(() -> new CustomEntityNotFoundException(Teammate.class, teammateId));
        if (!teammate.getTeam().getId().equals(teamId)) {
            throw new IllegalArgumentException("Teammate does not belong to this team");
        }
        teammateRepository.delete(teammate);
    }
    }

