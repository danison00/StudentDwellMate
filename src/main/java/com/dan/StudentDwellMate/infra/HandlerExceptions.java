package com.dan.StudentDwellMate.infra;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dan.StudentDwellMate.model.dto.ErrorResponseDto;

@RestControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> ex(DataIntegrityViolationException e) {
        if (e.getMostSpecificCause().getMessage().contains("email"))
            return ResponseEntity.badRequest().body(new ErrorResponseDto("none", "Email já existe.", false));
        return ResponseEntity.badRequest().build();

    }
}
