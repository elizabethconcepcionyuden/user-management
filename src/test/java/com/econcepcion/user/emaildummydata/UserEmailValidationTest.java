package com.econcepcion.user.emaildummydata;

import com.econcepcion.user.model.entity.User;
import com.econcepcion.user.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserEmailValidationTest {

    @Autowired
    private UserRepository userRepository;

    // Save a user with a valid email and verify it is stored
    @Test
    @DisplayName("Save user with valid email")
    void saveUser_withValidEmail_shouldPersist() {
        User user = createUser("valid@email.com");

        User savedUser = userRepository.save(user);

        assertThat(savedUser.getId()).isNotNull();
        assertThat(savedUser.getEmail()).isEqualTo("valid@email.com");
    }

    // Try to save two users with the same email and expect a constraint violation
    @Test
    @DisplayName("Save two users with same email should fail")
    void saveUser_withDuplicateEmail_shouldThrowError() {
        User user1 = createUser("duplicate@email.com");
        User user2 = createUser("duplicate@email.com");

        userRepository.save(user1);

        // This should throw an exception due to unique constraint on email
        Exception exception = null;
        try {
            userRepository.saveAndFlush(user2);
        } catch (Exception e) {
            exception = e;
        }

        assertThat(exception).isNotNull();
    }

    // Check that existsByEmail works with an email present in the DB
    @Test
    @DisplayName("existsByEmail returns true when email exists")
    void existsByEmail_existingEmail_returnsTrue() {
        User user = createUser("check@email.com");
        userRepository.save(user);

        boolean exists = userRepository.existsByEmail("check@email.com");

        assertThat(exists).isTrue();
    }

    // Check that existsByEmail returns false when email is not in the DB
    @Test
    @DisplayName("existsByEmail returns false when email does not exist")
    void existsByEmail_nonExistingEmail_returnsFalse() {
        boolean exists = userRepository.existsByEmail("notfound@email.com");

        assertThat(exists).isFalse();
    }

    // Find user by email and verify result
    @Test
    @DisplayName("findByEmail returns user")
    void findByEmail_existingEmail_returnsUser() {
        User user = createUser("findme@email.com");
        userRepository.save(user);

        Optional<User> found = userRepository.findUserByEmail("findme@email.com");

        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("Test User");
    }

    // Helper method to create a user
    private User createUser(String email) {
        Date now = new Date();
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setName("Test User");
        user.setEmail(email);
        user.setPassword("pass123");
        user.setIsActive(true);
        user.setToken("token123");
        user.setCreated(now);
        user.setModified(now);
        user.setLastLogin(now);
        return user;
    }
}

