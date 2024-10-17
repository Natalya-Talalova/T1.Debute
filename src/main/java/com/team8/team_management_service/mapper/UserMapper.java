package com.team8.team_management_service.mapper;

import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.User;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDto, User> {

    @Override
    User toEntity(UserDto dto);

    @Override
    UserDto toDto(User entity);

    @Override
    List<UserDto> toDtoList(List<User> entities);

    @Override
    List<User> toEntityList(List<UserDto> dtos);

}