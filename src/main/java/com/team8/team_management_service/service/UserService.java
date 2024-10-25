package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserService{

    UserDto create(UserDto userDto);

    UserDto update(UserDto user, Long id);

    void delete(Long id);

    UserDto findById(Long id);

    List<UserDto> findAll();

    List<UserDto> findByUsername(String username);

    UserDto partialUpdate(Long id, UserDto userDto);

    void updateProfilePicture(Long id, MultipartFile file);

    List<UserDto> searchUsers(String query);

    List<UserDto> findByQueryAndNoTeamId(String query, Long noTeamId);
}
