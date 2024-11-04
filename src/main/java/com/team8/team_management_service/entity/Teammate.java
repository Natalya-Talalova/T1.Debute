package com.team8.team_management_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "teammate", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "team_id"})
})
public class Teammate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "team_id", nullable = false, updatable = false)
    private Team team;

    @OneToMany(mappedBy = "teammate", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    @ElementCollection(targetClass = TeammateRole.class)
    @CollectionTable(
            name = "teammate_role",
            joinColumns = @JoinColumn(name = "teammate_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "teammate_role", nullable = false)
    private Set<TeammateRole> roles = Set.of(TeammateRole.MEMBER);
}