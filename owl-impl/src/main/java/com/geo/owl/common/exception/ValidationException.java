package com.geo.owl.common.exception;

public class ValidationException extends OwlBackendException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
