package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.entity.TeammateRole;
import com.team8.team_management_service.exception.EntityNotFoundByIdException;
import com.team8.team_management_service.mapper.TeammateMapper;
import com.team8.team_management_service.repository.TeammateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeammateServiceImpl implements TeammateService {

    private final TeammateMapper teammateMapper;
    private final TeammateRepository teammateRepository;

    public TeammateServiceImpl(TeammateMapper teammateMapper, TeammateRepository teammateRepository) {
        this.teammateMapper = teammateMapper;
        this.teammateRepository = teammateRepository;
    }

    @Override
    public TeammateDto create(TeammateDto teammateDto) {
        return null;
    }

    @Override
    public List<TeammateDto> findAllByTeamId(Long teamId) {
        return teammateMapper.toDtoList(teammateRepository.findByTeamId(teamId));
    }

    @Override
    public TeammateDto update(TeammateDto teammate, Long id) {
        return null;
    }

    @Override
    public TeammateDto findById(Long teamId, Long teammateId) {
        Teammate teammate = teammateRepository.findById(teammateId)
                .orElseThrow(() -> new EntityNotFoundByIdException(Teammate.class, teammateId));
        return teammateMapper.toDto(teammate);
    }

    @Override
    public TeammateDto findById(Long id) {
        return null;
    }

    @Override
    public TeammateDto addTeammate(Long teamId, TeammateDto teammateDto) {
        Teammate teammate = teammateMapper.toEntity(teammateDto);
        teammate.getTeam().setId(teamId); // Устанавливаем ID команды
        teammate = teammateRepository.save(teammate);
        return teammateMapper.toDto(teammate);
    }

    @Override
    public List<TeammateDto> findAll(Long teamId) {
        return List.of();
    }

    @Override
    public TeammateDto create(Long teamId, Long userId, TeammateRole role) {
        return null;
    }

    @Override
    public TeammateDto update(TeammateDto teammateDto, Long teammateId) {
        return null;
    }

    @Override
    public TeammateDto partialUpdate(TeammateDto teammateDto, Long teammateId) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    public List<Team> findTeamsByUserId(Long userId) {
        return teammateRepository.findByUserId(userId)
                .stream()
                .map(Teammate::getTeam)
                .collect(Collectors.toList());
    }

//    @Override
//    public TeammateDto updateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto) {
//        Teammate existingTeammate = teammateRepository.findById(teammateId)
//                .orElseThrow(() -> new EntityNotFoundByIdException(Teammate.class, teammateId));
//        if (!existingTeammate.getTeam().getId().equals(teamId)) {
//            throw new IllegalArgumentException("Teammate does not belong to this team");
//        }
//        Teammate updatedTeammate = teammateMapper.toEntity(teammateDto);
//        updatedTeammate.setId(teammateId);
//        updatedTeammate.getTeam().setId(teamId);
//        return teammateMapper.toDto(teammateRepository.save(updatedTeammate));
//    }
//
//    @Override
//    public TeammateDto partialUpdateTeammate(Long teamId, Long teammateId, TeammateDto teammateDto) {
//        return null;
//    }
//
//
//    @Override
//    public void deleteTeammate(Long teamId, Long teammateId) {
//        Teammate teammate = teammateRepository.findById(teammateId)
//                .orElseThrow(() -> new EntityNotFoundByIdException(Teammate.class, teammateId));
//        if (!teammate.getTeam().getId().equals(teamId)) {
//            throw new IllegalArgumentException("Teammate does not belong to this team");
//        }
//        teammateRepository.delete(teammate);
//    }
}

