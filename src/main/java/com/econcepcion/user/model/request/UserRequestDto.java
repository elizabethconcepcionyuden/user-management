package com.econcepcion.user.model.request;

import com.econcepcion.user.validation.ValidEmail;
import com.econcepcion.user.validation.ValidPassword;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class UserRequestDto {

    @NotBlank(message = "{field.required}")
    private String name;

    @ValidEmail
    @NotBlank(message = "{field.required}")
    private String email;

    @ValidPassword(message = "{password.invalid.format}")
    @NotBlank(message = "{field.required}")
    private String password;

    private List<PhoneRequestDto> phones;
}



