package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeammateServiceImpl implements TeammateService {
    @Override
    public TeammateDto create(TeammateDto teammateDto) {
        return null;
    }

    @Override
    public TeammateDto update(TeammateDto teammate, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TeammateDto findById(Long id) {
        return null;
    }

    @Override
    public List<TeammateDto> findAll() {
        return List.of();
    }
}
