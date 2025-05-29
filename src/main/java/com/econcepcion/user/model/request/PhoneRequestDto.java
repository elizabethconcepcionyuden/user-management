package com.econcepcion.user.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhoneRequestDto {

    @NotBlank(message = "El número es obligatorio")
    private String number;

    @NotBlank(message = "El código de ciudad es obligatorio")
    private String cityCode;

    @NotBlank(message = "El código de país es obligatorio")
    private String countryCode;
}
