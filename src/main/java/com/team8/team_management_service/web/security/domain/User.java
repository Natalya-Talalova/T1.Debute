package com.team8.team_management_service.web.security.domain;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private Set<Role> roles;
}
