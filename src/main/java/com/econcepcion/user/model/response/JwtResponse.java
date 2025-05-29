package com.econcepcion.user.model.response;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;
    private String email;

    public JwtResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }

}