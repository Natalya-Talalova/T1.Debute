package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.entity.Team;

import java.util.List;

import org.mapstruct.*;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamMapper extends BaseMapper<TeamDto, Team> {

    @Override
    Team toEntity(TeamDto dto);

    @Override
    TeamDto toDto(Team entity);

    @Override
    List<TeamDto> toDtoList(List<Team> entities);

    @Override
    List<Team> toEntityList(List<TeamDto> dtos);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team partialUpdate(TeamDto teamDto, @MappingTarget Team team);

}