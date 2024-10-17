package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.TeamDto;
import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.entity.User;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = ComponentModel.SPRING)
public interface TeamMapper extends
    BaseMapper<TeamDto, Team> {

    @Override
    Team toEntity(TeamDto dto);

    @Override
    TeamDto toDto(Team entity);

    @Override
    List<TeamDto> toDtoList(List<Team> entities);

    @Override
    List<Team> toEntityList(List<TeamDto> dtos);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Team partialUpdate(
        TeamDto teamDto, @MappingTarget Team team);
}