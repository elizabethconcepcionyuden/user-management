package com.econcepcion.user.exception;

/**
 * Excepción para conflictos, por ejemplo datos duplicados (HTTP 409).
 */
public class ResourceConflictException extends ApiException {

    public ResourceConflictException(String message) {
        super(message);
    }
}
