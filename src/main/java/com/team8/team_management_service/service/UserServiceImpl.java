package com.team8.team_management_service.service;

import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.User;
import com.team8.team_management_service.exception.EntityNotFoundByIdException;
import com.team8.team_management_service.mapper.UserMapper;
import com.team8.team_management_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public UserDto create(UserDto userDto) {
        User entity = userMapper.toEntity(userDto);
        entity = userRepository.save(entity);
        System.out.println(entity.getId());
        return userMapper.toDto(entity);
    }

    @Override
    public UserDto update(UserDto user, Long id) {
        User entity = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundByIdException(User.class, id));
        User updatedUser = userMapper.partialUpdate(user, entity);
        return userMapper.toDto(updatedUser);
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundByIdException(User.class, id);
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public UserDto findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundByIdException(User.class, id));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public List<UserDto> findByUsername(String username) {
        return userRepository.findByUsername(username)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public UserDto partialUpdate(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundByIdException(User.class, id));
        User updatedUser = userMapper.partialUpdate(userDto, user);
        updatedUser = userRepository.save(updatedUser);
        return userMapper.toDto(updatedUser);
    }


}
