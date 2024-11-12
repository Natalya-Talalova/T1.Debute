package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService{

    List<UserDto> findAll();

    UserDto findById(Long id);

    UserDto create(UserDto userDto);

    UserDto partialUpdate(Long id, UserDto userDto);

    UserDto update(UserDto user, Long id);

    void delete(Long id);

    List<UserDto> findByUsername(String username);

    List<UserDto> searchUsers(String query);

    List<UserDto> findByQueryAndNoTeamId(String query, Long noTeamId);

    ResponseEntity<String> updateProfilePicture(Long id, String priofilePicture);
}
