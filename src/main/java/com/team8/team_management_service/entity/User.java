package com.team8.team_management_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "phone_number", nullable = false, length = 11)
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    String phoneNumber;

    @Column(name = "age", nullable = false)
    int age;

    @Column(name = "username", nullable = false, unique = true)
    @Size(min = 2, max = 256, message = "Username must be between 2 and 256 characters")
    private String username;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 256, message = "Password must be between 8 and 256 characters")
    private String password;

    @Column(name = "name", nullable = false, length = 256)
    @Size(min = 2, max = 256, message = "Name must be between 2 and 256 characters")
    String name;

    @Column(name = "lastname", nullable = false, length = 256)
    @Size(min = 2, max = 256, message = "lastname must be between 2 and 256 characters")
    String lastname;

    @Column(name = "position", nullable = false, length = 256)
    @Size(min = 2, max = 256, message = "Position must be between 2 and 256 characters")
    String position;

    @Column(name = "experience", nullable = false, length = 2048)
    @Size(min = 2, max = 2048, message = "Expirience must be between 2 and 2048 characters")
    String experience;

    @Column(name = "messenger", nullable = false, length = 256)
    @Size(min = 2, max = 256, message = "Messenger must be between 2 and 256 characters")
    String messenger;

    public Long getId() {
        return id;
    }

    @Column(name = "skills", nullable = false, length = 2048)
    @Size(min = 2, max = 2048, message = "Skills must be between 2 and 2048 characters")
    String skills;

    @Column(name = "area_of_responsibility", nullable = false, length = 512)
    @Size(min = 2, max = 512, message = "Area of responsibility must be between 2 and 512 characters")
    String areaOfResponsibility;

    @Column(name = "visibility", nullable = false)
    @NotNull
    boolean visibility;

    @Lob
    @Column(name = "profile_picture")
    byte[] profilePicture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
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
    User user = (User) o;
    return id != null && Objects.equals(id, user.id);
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
  }

}