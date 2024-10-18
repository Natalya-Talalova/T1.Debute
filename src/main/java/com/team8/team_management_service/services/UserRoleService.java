package com.team8.team_management_service.services;

import com.team8.team_management_service.entity.UserRole;
import com.team8.team_management_service.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleService {
    public List<UserRole> getAllRoles();
}
