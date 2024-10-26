package com.team8.team_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * DTO for {@link com.team8.team_management_service.entity.User}
 */
@Getter
public class UserDto implements Serializable {

    private final Long id;
    @Size(message = "Имя должно быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String name;
    @Size(message = "Имя должно быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String username;
    @Size(message = "Пароль должен быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String password;
    @Size(message = "Фамилия должна быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String lastname;
    @Size(message = "Должность должна быть длиной от 2 до 256 символов", min = 2, max = 256)
    @NotBlank
    private final String position;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String experience;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String messenger;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String phoneNumber;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String skills;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final String areaOfResponsibility;
    private final int age;
    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final boolean visibility;
    private final byte[] profilePicture;

    public UserDto(Long id, String username, String password, String name, String lastname, String position, String experience, String messenger, String phoneNumber, String skills, String areaOfResponsibility, int age, boolean visibility, byte[] profilePicture) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.position = position;
        this.experience = experience;
        this.messenger = messenger;
        this.phoneNumber = phoneNumber;
        this.skills = skills;
        this.areaOfResponsibility = areaOfResponsibility;
        this.age = age;
        this.visibility = visibility;
        this.profilePicture = profilePicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.lastname, entity.lastname) &&
                Objects.equals(this.position, entity.position) &&
                Objects.equals(this.experience, entity.experience) &&
                Objects.equals(this.messenger, entity.messenger) &&
                Objects.equals(this.phoneNumber, entity.phoneNumber) &&
                Objects.equals(this.skills, entity.skills) &&
                Objects.equals(this.areaOfResponsibility, entity.areaOfResponsibility) &&
                Objects.equals(this.age, entity.age) &&
                Objects.equals(this.visibility, entity.visibility) &&
                Objects.equals(this.profilePicture, entity.profilePicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, lastname, position, experience, messenger, phoneNumber, skills, areaOfResponsibility, age, visibility, profilePicture);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "name = " + name + ", " +
                "lastname = " + lastname + ", " +
                "position = " + position + ", " +
                "expirience = " + experience + ", " +
                "messenger = " + messenger + ", " +
                "phoneNumber = " + phoneNumber + ", " +
                "skills = " + skills + ", " +
                "areaOfResponsibility = " + areaOfResponsibility + ", " +
                "age = " + age + ", " +
                "visibility = " + visibility + ")";
    }
}