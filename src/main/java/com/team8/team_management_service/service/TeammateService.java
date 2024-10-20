package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.TeammateDto;

import java.util.List;

public interface TeammateService {

    TeammateDto create(TeammateDto teammateDto);

    TeammateDto update(TeammateDto teammate, Long id);

    void delete(Long id);

    TeammateDto findById(Long id);

    List<TeammateDto> findAll();


}
