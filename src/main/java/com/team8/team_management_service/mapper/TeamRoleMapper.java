package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.TeammateRoleDto;
import com.team8.team_management_service.entity.TeammateRole;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TeamRoleMapper extends BaseMapper<TeammateRoleDto, TeammateRole> {



    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TeammateRole partialUpdate(TeammateRoleDto teammateRoleDto, @MappingTarget TeammateRole teammateRole);
}