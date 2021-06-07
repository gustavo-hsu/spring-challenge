package com.br.meli.springchallenge.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestApiException extends ApiException {
    private final static String CODE = "BAD_REQUEST";
    private final static Integer STATUS_CODE = HttpStatus.BAD_REQUEST.value();

    public BadRequestApiException() {
        super(CODE, CODE, STATUS_CODE);
    }

    public BadRequestApiException(String description) {
        super(CODE, description, STATUS_CODE);
    }

    public BadRequestApiException(String code, String description, Throwable cause) {
        super(code, description, STATUS_CODE, cause);
    }

    public BadRequestApiException(String description, Throwable cause) {
        super(CODE, description, STATUS_CODE, cause);
    }

    public BadRequestApiException(String description, String messageCause) {
        super(CODE, description, STATUS_CODE, messageCause);
    }
}