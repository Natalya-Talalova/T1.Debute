package com.team8.team_management_service.dto;

import com.team8.team_management_service.entity.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link User}
 */
public class UserDto implements Serializable {

    private final Long id;
    @Size(message = "Имя должно быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String name;
    @Size(message = "Фамилия должна быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String lastname;
    @Size(message = "Должность должна быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String position;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String expirience;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String messenger;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final int phoneNumber;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String skills;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String areaOfResponsibility;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final int age;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final boolean visibility;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String username;

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", position='" + position + '\'' +
                ", expirience='" + expirience + '\'' +
                ", messenger='" + messenger + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", skills='" + skills + '\'' +
                ", areaOfResponsibility='" + areaOfResponsibility + '\'' +
                ", age=" + age +
                ", visibility=" + visibility +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return phoneNumber == userDto.phoneNumber && age == userDto.age && visibility == userDto.visibility && Objects.equals(id, userDto.id) && Objects.equals(name, userDto.name) && Objects.equals(lastname, userDto.lastname) && Objects.equals(position, userDto.position) && Objects.equals(expirience, userDto.expirience) && Objects.equals(messenger, userDto.messenger) && Objects.equals(skills, userDto.skills) && Objects.equals(areaOfResponsibility, userDto.areaOfResponsibility) && Objects.equals(username, userDto.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, position, expirience, messenger, phoneNumber, skills, areaOfResponsibility, age, visibility, username);
    }

    public String getUsername() {
        return username;
    }

    public UserDto(Long id, String name, String lastname, String position, String expirience, String messenger, int phoneNumber, String skills, String areaOfResponsibility, int age, boolean visibility, String username) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.expirience = expirience;
        this.messenger = messenger;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
        this.areaOfResponsibility = areaOfResponsibility;
        this.age = age;
        this.visibility = visibility;
        this.username = username;
    }

    public Long getId() {
        return id;
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

}