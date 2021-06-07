package com.br.meli.springchallenge.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@Setter
public class ApiException extends Exception{
    private static final long serialVersionUID = 1L;

    private String code;
    private String description;
    private Integer statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    private String messageCause;

    public ApiException(String description) {
        this.code = "INTERNAL_ERROR";
        this.description = description;
    }

    public ApiException(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public ApiException(String code, String description, Integer statusCode) {
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public ApiException(String code, String description, Integer statusCode, Throwable cause) {
        super(cause);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
        this.messageCause = cause.getMessage();
    }

    public ApiException(String code, String description, Integer statusCode, String messageCause) {
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
        this.messageCause = messageCause;
    }

    public ApiException(String code, String description, Throwable cause) {
        super(cause);
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String toJson() {
        Map<String, Object> exceptionMap = new LinkedHashMap<>();

        exceptionMap.put("error", code);
        exceptionMap.put("message", description);
        exceptionMap.put("status", statusCode);

        if (messageCause != null) {
            exceptionMap.put("cause", messageCause);
        }

        return "{" + "\n   error: " + code + ",\n   description: " +
                    description + ",\n   status: " + statusCode + "\n}";
    }
}
