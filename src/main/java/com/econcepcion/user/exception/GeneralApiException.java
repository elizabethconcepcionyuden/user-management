package com.econcepcion.user.exception;

/**
 * Excepción genérica para errores internos del servidor (HTTP 500).
 */
public class GeneralApiException extends ApiException {

    public GeneralApiException(String message) {
        super(message);
    }
}