package com.econcepcion.user.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

    @Entity
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Table(name = "\"user\"")
    public class User implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        private UUID id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "email", nullable = false, unique = true)
        private String email;

        @Column(name = "password", nullable = false)
        private String password;

        @OneToMany(
                cascade = CascadeType.ALL,
                orphanRemoval = true,
                mappedBy = "user",
                fetch = FetchType.LAZY
        )
        private List<Phone> phones;

        @Column(name = "is_active", nullable = false)
        private Boolean isActive;

        @Column(name = "created", nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date created;

        @Column(name = "modified", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date modified;

        @Column(name = "last_login", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date lastLogin;

        @Column(name = "token", nullable = false)
        private String token;

        public void initializeDefaults(Date now, String token) {
            if (this.id == null) {
                this.id = UUID.randomUUID();
            }
            this.created = now;
            this.modified = now;
            this.lastLogin = now;
            this.isActive = true;
            this.token = token;
        }
    }
