package com.team8.team_management_service.repository;

import com.team8.team_management_service.entity.User;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User validUser;

    @BeforeEach
    void setUp() {
        validUser = new User();
        validUser.setPhoneNumber("12345678901");
//        validUser.setAge(30);
        validUser.setUsername("username");
        validUser.setPassword("password123");
        validUser.setName("John");
        validUser.setLastname("Doe");
        validUser.setPosition("Developer");
        validUser.setExperience("5 years of experience");
        validUser.setMessenger("Telegram");
        validUser.setSkills("Java, Spring Boot");
        validUser.setAreaOfResponsibility("Backend development");
        validUser.setVisibility(true);
    }

    @Test
    void shouldSaveUserSuccessfully() {
        User savedUser = userRepository.save(validUser);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getPhoneNumber()).isEqualTo("12345678901");
        assertThat(savedUser.isVisibility()).isTrue();
    }

    @Test
    void shouldFailToSaveUserWithInvalidPhoneNumber() {
        validUser.setPhoneNumber("123"); // Неверный номер телефона

        assertThatThrownBy(() -> userRepository.saveAndFlush(validUser))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void shouldFailToSaveUserWithShortPassword() {
        validUser.setPassword("short"); // Слишком короткий пароль

        assertThatThrownBy(() -> userRepository.saveAndFlush(validUser))
                .isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void shouldUpdateUserNameSuccessfully() {
        User savedUser = userRepository.save(validUser);
        savedUser.setUsername("new_username");

        User updatedUser = userRepository.save(savedUser);

        assertThat(updatedUser.getUsername()).isEqualTo("new_username");
    }

    @Test
    void shouldNotAllowDuplicateUsername() {
        userRepository.save(validUser);

        User duplicateUser = new User();
        duplicateUser.setPhoneNumber("09876543210");
//        duplicateUser.setAge(25);
        duplicateUser.setUsername("username"); // Дублирующийся username
        duplicateUser.setPassword("anotherpass123");
        duplicateUser.setName("Jane");
        duplicateUser.setLastname("Smith");
        duplicateUser.setPosition("Manager");
        duplicateUser.setExperience("2 years");
        duplicateUser.setMessenger("WhatsApp");
        duplicateUser.setSkills("Python, Django");
        duplicateUser.setAreaOfResponsibility("Frontend development");
        duplicateUser.setVisibility(false);

        assertThatThrownBy(() -> userRepository.saveAndFlush(duplicateUser))
                .isInstanceOf(DataIntegrityViolationException.class); // Исключение из-за уникального ограничения
    }

    @Test
    void shouldToggleVisibility() {
        User savedUser = userRepository.save(validUser);

        savedUser.setVisibility(!savedUser.isVisibility());
        User updatedUser = userRepository.save(savedUser);

        assertThat(updatedUser.isVisibility()).isFalse();
    }

    @Test
    void shouldDeleteUserSuccessfully() {
        User savedUser = userRepository.save(validUser);

        userRepository.delete(savedUser);

        Optional<User> deletedUser = userRepository.findById(savedUser.getId());
        assertThat(deletedUser).isEmpty();
    }

    @Test
    void shouldVerifyEqualsForSameIdInDatabase() {
        // Сохранение пользователя в базе данных
        User savedUser1 = userRepository.save(validUser);

        // Загрузка того же пользователя еще раз из базы данных
        User fetchedUser1 = userRepository.findById(savedUser1.getId()).orElseThrow();

        // Проверка равенства и хэш-кода
        assertThat(savedUser1).isEqualTo(fetchedUser1);
    }

    @Test
    void shouldVerifyEqualsForDifferentIdsInDatabase() {
        // Сохранение двух пользователей в базе данных
        User savedUser1 = userRepository.save(validUser);

        User differentUser = new User();
        differentUser.setPhoneNumber("09876543210");
//        differentUser.setAge(25);
        differentUser.setUsername("differentUser");
        differentUser.setPassword("differentPass123");
        differentUser.setName("Jane");
        differentUser.setLastname("Smith");
        differentUser.setPosition("Designer");
        differentUser.setExperience("3 years of experience");
        differentUser.setMessenger("WhatsApp");
        differentUser.setSkills("UI/UX Design");
        differentUser.setAreaOfResponsibility("Frontend development");
        differentUser.setVisibility(false);

        User savedUser2 = userRepository.save(differentUser);

        // Проверка неравенства и различных хэш-кодов для пользователей с разными id
        assertThat(savedUser1).isNotEqualTo(savedUser2);
    }
}