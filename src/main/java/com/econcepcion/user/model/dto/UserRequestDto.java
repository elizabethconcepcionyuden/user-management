package com.econcepcion.user.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserRequestDto {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotBlank(message = "El correo es obligatorio")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

    @NotNull(message = "Los teléfonos no pueden estar vacíos")
    @Size(min = 1, message = "Debe haber al menos un teléfono")
    private List<PhoneRequestDto> phones;

    private Date created;

    private Date modified;

    private Date lastLogin;

    private Boolean isActive;
}
