package com.team8.team_management_service;

import com.team8.team_management_service.mapper.UserMapper;
import com.team8.team_management_service.repository.UserRepository;
import com.team8.team_management_service.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Test
    public void testCreateUser() {

    }
}
