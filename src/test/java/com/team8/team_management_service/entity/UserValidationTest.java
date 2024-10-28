package com.team8.team_management_service.entity;

import com.team8.team_management_service.repository.UserRepository;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserValidationTest {

    private static Faker faker;
    private final UserRepository userRepository;
    private User user;

    @Autowired
    public UserValidationTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeAll
    protected static void setUp() {
        faker = new Faker();
    }

    @BeforeEach
    void testUserValidation() {
        user = User.builder()
                .name(faker.name().firstName())
                .username(faker.internet().username())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .build();
    }

    @Test
    void testSaveBaseUser() {
        User savedUser = userRepository.save(user);
        assertThat(savedUser.getId()).isNotNull();
    }


}