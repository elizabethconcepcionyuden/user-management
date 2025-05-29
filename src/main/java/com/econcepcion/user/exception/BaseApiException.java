package com.econcepcion.user.exception;

/**
 * Clase base para excepciones personalizadas de la API.
 */
public class BaseApiException extends RuntimeException {

    public BaseApiException(String message) {
        super(message);
    }

    public BaseApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseApiException(Throwable cause) {
        super(cause);
    }
}
