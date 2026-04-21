package com.app.restfulprac.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MemberException extends RuntimeException {

    private HttpStatus httpStatus;

    public MemberException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
