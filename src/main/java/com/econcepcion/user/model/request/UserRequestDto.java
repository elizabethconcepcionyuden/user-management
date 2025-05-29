package com.econcepcion.user.model.request;

import com.econcepcion.user.validation.ValidEmail;
import com.econcepcion.user.validation.ValidPassword;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {

    @Size(max = 55)
    @NotBlank(message = "{field.required}")
    private String name;

    @ValidEmail
    @Size(max = 55)
    @NotBlank(message = "{field.required}")
    private String email;

    @ValidPassword(message = "{password.invalid.complexity}")
    @NotBlank(message = "{field.required}")
    private String password;

    private List<@Valid PhoneRequestDto> phones;
}



