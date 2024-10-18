package com.team8.team_management_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teammates")
public class Teammate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private TeammateRole role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TeammateRole getRole() {
        return role;
    }

    public void setRole(TeammateRole role) {
        this.role = role;
    }
}