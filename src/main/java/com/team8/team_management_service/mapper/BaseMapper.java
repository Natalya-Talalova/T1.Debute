package com.team8.team_management_service.mapper;

import java.util.List;

public interface BaseMapper<D, E> {
    E toEntity(D dto);

    D toDto(E entity);

    List<D> toDtoList(List<E> entities);

    List<E> toEntityList(List<D> dtos);

    E partialUpdate(D dto, E entity);
}
