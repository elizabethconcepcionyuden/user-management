package com.econcepcion.user.exception;

import com.econcepcion.user.model.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestApiException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleBadRequest(BadRequestApiException ex) {
        return new ErrorResponseDto(ex.getLocalizedMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleValidationException(MethodArgumentNotValidException ex) {
        return ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> new ErrorResponseDto(
                        error.getField() + ": " + Objects.requireNonNull(error.getDefaultMessage()))
                ).orElseGet(() -> new ErrorResponseDto("Solicitud inválida"));
    }

    @ExceptionHandler(ResourceConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponseDto handleConflict(ResourceConflictException ex) {
        return new ErrorResponseDto(ex.getLocalizedMessage());
    }

    @ExceptionHandler(GeneralApiException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto handleServerError(GeneralApiException ex) {
        return new ErrorResponseDto("Error interno del servidor");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto handleUnexpectedError(Exception ex) {
        return new ErrorResponseDto("Se produjo un error inesperado");
    }
}
