package com.team8.team_management_service.entity;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class UserValidationTest {

    User user;
    Faker faker;

    public UserValidationTest(Faker faker) {
        this.faker = faker;
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
}