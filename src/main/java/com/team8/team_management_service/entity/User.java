package com.team8.team_management_service.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    String name;
    String lastname;
    String position;
    String expirience;
    String messenger;
    int phoneNumber;
    String skills;
    String areaOfResponsibility;
    int age;
    boolean visibility;

     public User(String name, String lastname, int age, String position, String messenger, int phoneNumber, String skills, String areaOfResponsibility, boolean visibility) {
         this.name = name;
         this.lastname = lastname;
         this.age = age;
         this.position = position;
         this.messenger = messenger;
         this.phoneNumber = phoneNumber;
         this.skills = skills;
         this.areaOfResponsibility = areaOfResponsibility;
         this.visibility = visibility;
     }

    public User() {

    }

    public void setName(String name) {
         if(name.length() < 100) {
             this.name = name;
         } else {
             System.out.println("Имя слишком длинное");
         }
     }

    public void setLastname(String lastname) {
        if(lastname.length() < 100) {
            this.lastname = lastname;
        } else {
            System.out.println("Фамилия слишком длинная");
        }
    }

    public void setAge(int age) {
        if(age < 0) {
            this.age = age;
        } else {
            System.out.println("Возраст не может быть отрицательным");
        }
    }

    public void setPosition(String position) {
        if(position.length() < 100) {
            this.position = position;
        } else {
            System.out.println("Должность слишком длинная");
        }
    }

    public void setExpirience(String expirience) {
         this.expirience = expirience;
    }

    public void setMessenger(String messenger) {
        if(messenger.length() < 100) {
            this.messenger = messenger;
        } else {
            System.out.println("Мессенджер слишком длинный");
        }
    }

    public void setPhone_number(int phone_number) {
        if(phone_number == 11) {
            this.phoneNumber = phone_number;
        } else {
            System.out.println("Должность слишком длинная");
        }
    }

    public void setSkills(String skills) {
            this.skills = skills;
        }

    public void setArea_of_responsibility(String area_of_responsibility) {
        if(area_of_responsibility.length() < 100) {
            this.areaOfResponsibility = area_of_responsibility;
        } else {
            System.out.println("Зона ответственности слишком длинная");
        }
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

  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinTable(name = "team_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
  Set<Team> teams;

  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
  @JoinTable(name = "invited_team_user", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
  Set<Team> invitedTeams;

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