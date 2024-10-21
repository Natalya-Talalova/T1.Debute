package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.create(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    // Обновление пользователя по ID
    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto, @PathVariable Long id) {
        return userService.update(userDto, id);
    }

//    @PatchMapping("/{id}")
//    public UserDto partialUpdateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
//        return userService.partialUpdate(id, userDto);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Поиск пользователя по юзернейму
    @GetMapping("/username/{username}")
    public ResponseEntity<List<UserDto>> getUsersByUsername(@PathVariable String username) {
        List<UserDto> users = userService.findByUsername(username);
        return ResponseEntity.ok(users);
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<UserDto> partialUpdateUser(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        UserDto user = userService.partialUpdate(id, fields);
        return ResponseEntity.ok(user);
    }

}
