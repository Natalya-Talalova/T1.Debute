package com.team8.team_management_service.service;

import com.team8.team_management_service.repository.InviteRepository;
import com.team8.team_management_service.repository.TeamRepository;
import org.springframework.stereotype.Service;

@Service
public interface InviteService {
    public String create(Long teamId);
}
