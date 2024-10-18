package com.team8.team_management_service.services;

import com.team8.team_management_service.dto.UserDto;
import com.team8.team_management_service.entity.User;
import com.team8.team_management_service.mapper.UserMapper;
import com.team8.team_management_service.mapper.UserMapperImpl;
import com.team8.team_management_service.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface UserService{
    UserDto findById(Long id);

    List<UserDto> findAll();

    void delete(Long id);

    UserDto save(UserDto user);

    void update(UserDto user);

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper = new UserMapperImpl();

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public default boolean authenticate(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Проверка пароля (рекомендуется хешировать пароль в реальной системе)
            return user.getPassword().equals(password);
        }
        return false;
    }

    // Получение всех пользователей
    public default List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto) // Преобразуем User в UserDto с помощью маппера
                .collect(Collectors.toList());
    }

    // Получение пользователя по ID
    public default UserDto getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userMapper.toDto(userOptional.get());
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    // Создание нового пользователя
    public default UserDto createUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto); // Преобразуем DTO в сущность User
        User savedUser = userRepository.save(user); // Сохраняем пользователя в базу
        return userMapper.toDto(savedUser); // Возвращаем DTO сохраненного пользователя
    }

    // Обновление пользователя по ID
    @Transactional
    public default UserDto updateUser(Long id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setUsername(userDto.getUsername()); // Пример, обновляем поля
            // можно обновить и другие поля
            return userMapper.toDto(userRepository.save(userToUpdate)); // Возвращаем обновленного пользователя
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

    // Удаление пользователя по ID
    public default void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }

}
