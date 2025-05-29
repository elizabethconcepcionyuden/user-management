package com.econcepcion.user.repository;


import com.econcepcion.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean isEmailRegistered(String email);
}

