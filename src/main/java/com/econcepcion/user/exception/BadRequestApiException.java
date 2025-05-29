package com.econcepcion.user.exception;

/**
 * Excepción para errores de petición inválida (HTTP 400).
 */
public class BadRequestApiException extends ApiException {

    public BadRequestApiException(String message) {
        super(message);
    }
}