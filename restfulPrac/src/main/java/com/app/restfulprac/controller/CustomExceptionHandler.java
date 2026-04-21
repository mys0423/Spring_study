package com.app.restfulprac.controller;

import com.app.restfulprac.domain.dto.ApiResponseDTO;
import com.app.restfulprac.exception.MemberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(MemberException.class)
    public ResponseEntity<ApiResponseDTO> handleMemberException(MemberException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(ApiResponseDTO.of(e.getMessage()));
    }
}
