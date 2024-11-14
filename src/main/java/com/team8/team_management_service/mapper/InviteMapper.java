package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.InviteDto;
import com.team8.team_management_service.dto.TaskDto;
import com.team8.team_management_service.entity.Invite;
import com.team8.team_management_service.entity.Task;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InviteMapper extends BaseMapper<InviteDto, Invite>{
    @Override
    Invite toEntity(InviteDto dto);

    @Override
    InviteDto toDto(Invite entity);

    @Override
    List<InviteDto> toDtoList(List<Invite> entities);

    @Override
    List<Invite> toEntityList(List<InviteDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Invite partialUpdate(InviteDto inviteDto, @MappingTarget Invite invite);
}
