package com.team8.team_management_service.controller;

import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.User;
import com.team8.team_management_service.repository.UserRepository;
import com.team8.team_management_service.service.UserService;
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
    private final UserRepository userRepository;

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

    @PatchMapping("/{id}")
    public UserDto partialUpdateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.partialUpdate(id, userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("?username={username}")
    public List<UserDto> getUsersByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @PatchMapping("/user/{id}")
    public String updateProfilePicture(@PathVariable Long id, @RequestParam("profilePicture") MultipartFile file) {
        userService.updateProfilePicture(id, file);
        return "Profile picture updated successfully";
    }

    @GetMapping("/{id}/profile-picture")
    public ResponseEntity<byte[]> getProfilePicture(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        byte[] profilePicture = user.getPic();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(profilePicture);
    }

    @GetMapping("?search={query}&noTeamId={noTeamId}")
    public List<UserDto> searchUsers(@RequestParam("query") String query,
                                     @RequestParam("noTeamId") Long noTeamId) {
        if (noTeamId != null) {
            return userService.findByQueryAndNoTeamId(query, noTeamId);
        }
        return userService.searchUsers(query);
    }

}
