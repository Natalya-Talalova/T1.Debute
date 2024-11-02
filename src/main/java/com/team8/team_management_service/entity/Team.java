package com.team8.team_management_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 1, max = 255)
    private String name;

    @Column(name = "description", length = 512, nullable = false)
    @Size(min = 2, max = 512)
    private String description;

    @Enumerated
    @Column(name = "team_status")
    private TeamStatus teamStatus;

    @Enumerated
    @Column(name = "team_type")
    private TeamType teamType;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Teammate> teammates = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Class<?> oEffectiveClass = o instanceof HibernateProxy
            ? ((HibernateProxy) o).getHibernateLazyInitializer()
            .getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer()
            .getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) {
            return false;
        }
        Team team = (Team) o;
        return getId() != null && Objects.equals(getId(), team.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer()
            .getPersistentClass().hashCode() : getClass().hashCode();
    }
}