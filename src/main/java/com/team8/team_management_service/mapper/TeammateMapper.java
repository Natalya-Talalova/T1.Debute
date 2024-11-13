package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Teammate;
import com.team8.team_management_service.entity.TeammateRole;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {TeamMapper.class})
public interface TeammateMapper extends BaseMapper<TeammateDto, Teammate> {

    @Override
    Teammate toEntity(TeammateDto dto);

    // Перегруженный метод для маппинга из отдельных параметров
    Teammate toEntity(Long userId, Long teamId, TeammateRole role);

    @Override
    TeammateDto toDto(Teammate entity);

    @Override
    List<TeammateDto> toDtoList(List<Teammate> entities);

    @Override
    List<Teammate> toEntityList(List<TeammateDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Teammate partialUpdate(TeammateDto teammateDto, @MappingTarget Teammate teammate);

}