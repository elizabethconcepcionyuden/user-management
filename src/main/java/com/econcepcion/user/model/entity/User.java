package com.econcepcion.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name ="name", nullable = false)
    private String name;

    @Column(name ="email", nullable = false, unique = true)
    private String email;

    @Column(name ="password", nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user", fetch = FetchType.LAZY)
    private List<Phone> phones;

    @Column(name ="is_active", nullable = false)
    private Boolean isActive;

    @Column(name ="created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name ="modified",nullable = false)
    private LocalDateTime modified;

    @Column(name ="last_login",nullable = false)
    private LocalDateTime lastLogin;

    @Column(name ="token",nullable = false)
    private String token;


}
