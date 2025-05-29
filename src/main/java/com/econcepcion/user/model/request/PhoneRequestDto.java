package com.econcepcion.user.model.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PhoneRequestDto {

    @Min(value = 0, message = "{number.required}")
    @Size(max = 15)
    @NotNull(message = "{field.required}")
    private String number;

    @Min(value = 0, message = "{number.required}")
    @Size(max = 15)
    @NotNull(message = "{field.required}")
    private String cityCode;

    @Min(value = 0, message = "{number.required}")
    @Size(max = 15)
    @NotNull(message = "{field.required}")
    private String countryCode;
}
