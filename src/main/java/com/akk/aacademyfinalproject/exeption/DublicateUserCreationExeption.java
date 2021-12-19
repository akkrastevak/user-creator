package com.akk.aacademyfinalproject.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DublicateUserCreationExeption extends RuntimeException{

    public DublicateUserCreationExeption(String message) {
        super(message);
    }
}
