package com.team8.team_management_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.FetchType.LAZY;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 2, max = 255)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    @Size(min = 2, max = 255)
    private String username;

    @Column(name = "lastname")
    @Size(min = 2, max = 255)
    private String lastname;

    @Column(name = "email", nullable = false, unique = true)
    @Size(min = 2, max = 255)
    private String email;

    @Column(name = "phone_number", length = 11)
    @Size(min = 11, max = 11)
    private String phoneNumber;

    @Column(name = "age")
    private LocalDate age;

    @Column(name = "password")
    @Size(min = 8, max = 255)
    private String password;

    @Column(name = "position")
    @Size(min = 2, max = 255)
    private String position;

    @Column(name = "experience", length = 2048)
    @Size(min = 2, max = 2048)
    private String experience;

    @Column(name = "messenger")
    @Size(min = 2, max = 255)
    private String messenger;

    @Column(name = "skills", length = 2048)
    @Size(min = 2, max = 2048)
    private String skills;

    @Column(name = "area_of_responsibility", length = 512)
    @Size(min = 2, max = 512)
    private String areaOfResponsibility;

    @Column(name = "visibility", nullable = false)
    @NotNull
    private boolean visibility = true;

    @Lob
    @Basic(fetch = LAZY)
    @Column(name = "PIC", columnDefinition = "BLOB NOT NULL")
    private byte[] pic;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Teammate> teammates = new ArrayList<>();

    @Override
    public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
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
    User user = (User) o;
    return id != null && Objects.equals(id, user.id);
    }

}