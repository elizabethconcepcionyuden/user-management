package com.econcepcion.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
    @GeneratedValue(generator = "UUID")
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
    private Date created;

    @Column(name ="modified",nullable = false)
    private Date modified;

    @Column(name ="last_login",nullable = false)
    private Date lastLogin;

    @Column(name ="token",nullable = false)
    private String token;

    public void initializeDefaults(Date now, String token) {
        this.created = now;
        this.modified = now;
        this.lastLogin = now;
        this.isActive = true;
        this.token = token;
    }


}
