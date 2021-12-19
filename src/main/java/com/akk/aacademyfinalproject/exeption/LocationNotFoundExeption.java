package com.akk.aacademyfinalproject.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationNotFoundExeption extends RuntimeException{

    public LocationNotFoundExeption(String message) {
        super(message);
    }
}
