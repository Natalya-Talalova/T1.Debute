package com.team8.team_management_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.team8.team_management_service.entity.User}
 */
@Data
public class UserDto implements Serializable {

    @Size(message = "Email должен быть длиной от 2 до 255 символов", min = 2, max = 255)
    private final String email;
    private final LocalDate birthDate;
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

    @Size(message = "Опыт должен быть длиной от 2 до 2048 символов", min = 2, max = 2048)
    @NotBlank
    private final boolean visibility;
}