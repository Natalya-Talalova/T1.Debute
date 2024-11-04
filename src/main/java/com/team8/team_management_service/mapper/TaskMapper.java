package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.TaskDto;
import com.team8.team_management_service.entity.Task;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper extends BaseMapper<TaskDto, Task> {

    @Override
    Task toEntity(TaskDto dto);

    @Override
    TaskDto toDto(Task entity);

    @Override
    List<TaskDto> toDtoList(List<Task> entities);

    @Override
    List<Task> toEntityList(List<TaskDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(TaskDto taskDto, @MappingTarget Task task);
}
