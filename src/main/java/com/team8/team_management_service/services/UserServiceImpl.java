package com.team8.team_management_service.services;

import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.User;
import com.team8.team_management_service.exception.CustomEntityNotFoundException;
import com.team8.team_management_service.mapper.UserMapper;
import java.util.List;

import com.team8.team_management_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserService.super.getAllUsers();
    }

    @Override
    public UserDto getUserById(Long id) {
        return UserService.super.getUserById(id);
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        return UserService.super.createUser(userDto);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        return UserService.super.updateUser(id, userDto);
    }

    @Override
    public void deleteUser(Long id) {
        UserService.super.deleteUser(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    @Transactional
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public UserDto save(UserDto user) {
        User entity = userMapper.toEntity(user);
        entity = userRepository.save(entity);
        return userMapper.toDto(entity);
    }

    @Override
    public void update(UserDto user) {
        if (!userRepository.existsById(user.getId())) {
            throw new CustomEntityNotFoundException(User.class, user.getId());
        }
        User entity = userMapper.toEntity(user);
        userRepository.save(entity);
    }

    @Override
    public boolean authenticate(String username, String password) {
        return false;
    }

}
