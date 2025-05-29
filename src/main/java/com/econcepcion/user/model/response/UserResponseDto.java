package com.econcepcion.user.model.response;

import lombok.Data;

import java.util.Date;
import java.util.UUID;
@Data
public class UserResponseDto {

    private UUID id;
    private Date lastLogin;
    private Date created;
    private Date modified;
    private String token;
    private Boolean isActive;

}
