package com.team8.team_management_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "users")
public class User {

    //TODO Profile picture, opportunity to be added to the team

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

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
    String expirience;

    @Column(name = "messenger", nullable = false, length = 256)
    @Size(min = 2, max = 256, message = "Messenger must be between 2 and 256 characters")
    String messenger;

    @Column(name = "phone_number", nullable = false, length = 11)
    @Size(min = 11, max = 11, message = "Phone number must be 11 characters")
    int phoneNumber;

    @Column(name = "skills", nullable = false, length = 2048)
    @Size(min = 2, max = 2048, message = "Skills must be between 2 and 2048 characters")
    String skills;

    @Column(name = "area_of_responsibility", nullable = false, length = 512)
    @Size(min = 2, max = 512, message = "Area of responsibility must be between 2 and 512 characters")
    String areaOfResponsibility;

    @Column(name = "age", nullable = false, length = 3)
    @Size(min = 1, max = 3, message = "Age must be between 1 and 3 characters")
    int age;

    @Column(name = "visibility", nullable = false)
    @NotNull
    boolean visibility;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setExpirience(String expirience) {
        this.expirience = expirience;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setAreaOfResponsibility(String areaOfResponsibility) {
        this.areaOfResponsibility = areaOfResponsibility;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPosition() {
        return position;
    }

    public String getExpirience() {
        return expirience;
    }

    public String getMessenger() {
        return messenger;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getSkills() {
        return skills;
    }

    public String getAreaOfResponsibility() {
        return areaOfResponsibility;
    }

    public int getAge() {
        return age;
    }

    public boolean isVisibility() {
        return visibility;
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

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
        .getPersistentClass().hashCode() : getClass().hashCode();
  }


}