package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.TeammateDto;
import com.team8.team_management_service.entity.Teammate;

import java.util.List;

public interface BaseMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDtoList(List<E> entities);

    List<E> toEntityList(List<D> dtos);

    Teammate partialUpdate(TeammateDto dto, Teammate entity);
}
