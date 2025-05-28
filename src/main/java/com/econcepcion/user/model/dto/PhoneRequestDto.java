package com.econcepcion.user.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhoneRequestDto {

    @NotBlank(message = "El número es obligatorio")
    private String number;

    @NotBlank(message = "El código de ciudad es obligatorio")
    private String citycode;

    @NotBlank(message = "El código de país es obligatorio")
    private String contrycode;
}
