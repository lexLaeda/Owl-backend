package com.geo.owl.common.exception;

public class OwlBackendException extends RuntimeException {

    public OwlBackendException(String message) {
        super(message);
    }

    public OwlBackendException(String message, Throwable cause) {
        super(message, cause);
    }
}
