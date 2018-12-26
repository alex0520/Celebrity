package com.globant.alozano.celebrity.exception;

/**
 * The class to define the controlled exceptions of the project
 */
public class CelebrityException extends RuntimeException {

    private static final long serialVersionUID = -7100172815005092057L;

    private final String message;

    public CelebrityException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
