package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Teammate;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface TeammateMapper extends BaseMapper<TeammateDto, Teammate> {

    @Override
    TeammateDto toDto(Teammate entity);

    @Override
    Teammate toEntity(TeammateDto dto);

    @Override
    List<TeammateDto> toDtoList(List<Teammate> entities);

    @Override
    List<Teammate> toEntityList(List<TeammateDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Teammate partialUpdate(
            TeammateDto teammateDto, @MappingTarget Teammate teammate);
}
