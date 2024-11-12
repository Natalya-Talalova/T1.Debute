package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.User;
import com.team8.team_management_service.repository.UserRepository;
import com.team8.team_management_service.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Получить всех пользователей")
    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @Operation(summary = "Создать нового пользователя")
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.create(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Получить пользователя по ID")
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @Operation(summary = "Обновить пользователя по ID")
    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        return userService.update(userDto, id);
    }

    @Operation(summary = "Частично обновить пользователя по ID")
    @PatchMapping("/{id}")
    public UserDto partialUpdateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.partialUpdate(id, userDto);
    }

    @Operation(summary = "Удалить пользователя по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Получить всех пользователей по имени")
    @GetMapping("?username={username}")
    public List<UserDto> getUsersByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @Operation(summary = "Получить всех пользователей по запросу")
    @GetMapping("?search={query}&noTeamId={noTeamId}")
    public List<UserDto> searchUsers(@RequestParam("query") String query,
                                     @RequestParam("noTeamId") Long noTeamId) {
        if (noTeamId != null) {
            return userService.findByQueryAndNoTeamId(query, noTeamId);
        }
        return userService.searchUsers(query);
    }

    @Operation(summary = "Загрузить фото профиля")
    @PostMapping("/users/{id}/profile-picture")
    public ResponseEntity<String> updateProfilePictureUrl(@PathVariable Long id, @RequestParam String pictureUrl) {
        return userService.updateProfilePicture(id, pictureUrl);
    }

}
