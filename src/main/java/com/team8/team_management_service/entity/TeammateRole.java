package com.team8.team_management_service.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.util.Collection;
import java.util.Objects;

import jakarta.validation.constraints.Size;
import org.hibernate.proxy.HibernateProxy;

@Entity(name = "teammate_roles")
public class TeammateRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 256, nullable = false)
    @Size(min = 2, max = 256, message = "Name must be between 2 and 256 characters")
    private String name;

    @ElementCollection(targetClass = TeammatePermission.class)
    @CollectionTable(name="team_role_access", joinColumns = @JoinColumn(name="team_role_id"))
    @Enumerated(EnumType.STRING)
    @Column(name="team_role_access")
    private Collection<TeammatePermission> teammatePermissions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        TeammateRole teammateRole = (TeammateRole) o;
        return getId() != null && Objects.equals(getId(), teammateRole.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer()
            .getPersistentClass().hashCode() : getClass().hashCode();
    }
}
