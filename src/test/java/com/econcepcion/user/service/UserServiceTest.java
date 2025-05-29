package com.econcepcion.user.service;

import com.econcepcion.user.model.entity.User;
import com.econcepcion.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    // Check if existsByEmail returns true when user is in the database
    @Test
    @DisplayName("existsByEmail returns true when user exists")
    void existsByEmail_userExists_returnsTrue() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName("Test User");
        user.setEmail("test@email.com");
        user.setPassword("123456");
        user.setIsActive(true);
        user.setToken("token-123");
        Date now = new Date();
        user.setCreated(now);
        user.setModified(now);
        user.setLastLogin(now);

        userRepository.save(user);

        boolean exists = userRepository.existsByEmail("test@email.com");

        assertThat(exists).isTrue();
    }

    // Check if existsByEmail returns false when email is not in the database
    @Test
    @DisplayName("existsByEmail returns false when user does not exist")
    void existsByEmail_userDoesNotExist_returnsFalse() {
        boolean exists = userRepository.existsByEmail("unknown@email.com");
        assertThat(exists).isFalse();
    }

    // Check that user can be saved and retrieved by email
    @Test
    @DisplayName("findByEmail returns user when found")
    void findByEmail_userExists_returnsUser() {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName("Another User");
        user.setEmail("another@email.com");
        user.setPassword("securePass");
        user.setIsActive(true);
        user.setToken("another-token");
        Date now = new Date();
        user.setCreated(now);
        user.setModified(now);
        user.setLastLogin(now);

        userRepository.save(user);

        User found = userRepository.findUserByEmail("another@email.com").orElse(null);

        assertThat(found).isNotNull();
        assertThat(found.getEmail()).isEqualTo("another@email.com");
    }
}
