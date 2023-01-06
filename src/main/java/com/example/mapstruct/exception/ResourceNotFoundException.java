package com.example.mapstruct.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private static final Long serialVersion = 1L;
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
