package com.econcepcion.user.model.response;

import java.util.Date;
import java.util.UUID;

public class UserResponseDto {

    private UUID id;
    private Date lastLogin;
    private Date created;
    private Date modified;
    private String token;
    private Boolean isActive;

}
