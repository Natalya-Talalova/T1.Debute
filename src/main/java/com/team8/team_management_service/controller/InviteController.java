package com.team8.team_management_service.controller;

import com.team8.team_management_service.service.InviteService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invites")
@AllArgsConstructor
public class InviteController {

    private final InviteService inviteService;

    @Operation(summary = "Создать приглашение")
    @PostMapping("/create/{teamId}")
    public String createInvite(@PathVariable Long teamId) {
        return inviteService.create(teamId);
    }

}
