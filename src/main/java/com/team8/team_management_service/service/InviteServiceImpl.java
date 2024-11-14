package com.team8.team_management_service.service;

import com.team8.team_management_service.entity.Invite;
import com.team8.team_management_service.entity.Team;
import com.team8.team_management_service.repository.InviteRepository;
import com.team8.team_management_service.repository.TeamRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class InviteServiceImpl implements InviteService {

    private final InviteRepository inviteRepository;
    private final TeamRepository teamRepository;

    @Override
    public String create(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException("Team not found"));

        String token = UUID.randomUUID().toString();
        LocalDateTime expiresAt = LocalDateTime.now().plusDays(7);

        Invite invite = new Invite();
        invite.setToken(token);
        invite.setTeam(team);
        invite.setExpiresAt(expiresAt);

        inviteRepository.save(invite);

        return "https://team-management-service.com/invite/" + token;
    }
}
