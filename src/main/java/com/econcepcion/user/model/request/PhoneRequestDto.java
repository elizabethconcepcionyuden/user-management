package com.econcepcion.user.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PhoneRequestDto {

    @NotBlank(message = "{phone.number.required}")
    private String number;

    @NotBlank(message = "{phone.cityCode.required}")
    private String cityCode;

    @NotBlank(message = "{phone.countryCode.required}")
    private String countryCode;
}
