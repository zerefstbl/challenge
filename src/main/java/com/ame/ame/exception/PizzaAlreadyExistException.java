package com.ame.ame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PizzaAlreadyExistException extends RuntimeException {
    public PizzaAlreadyExistException(String message) {
        super(message);
    }
}
