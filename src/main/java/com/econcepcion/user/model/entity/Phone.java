package com.econcepcion.user.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, length = 15)
    private String number;

    @Column(name = "city_code", nullable = false, length = 15)
    private String cityCode;

    @Column(name = "country_code", nullable = false, length = 15)
    private String countryCode;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
