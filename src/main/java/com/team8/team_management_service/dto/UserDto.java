package com.team8.team_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * DTO for {@link com.team8.team_management_service.entity.User}
 */
@Getter
@AllArgsConstructor
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
}