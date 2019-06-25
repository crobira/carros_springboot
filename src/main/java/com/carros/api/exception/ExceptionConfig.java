package com.carros.api.exception;

import com.carros.api.security.jwt.AuthorizationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionConfig extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity errorNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
           IllegalArgumentException.class
    })
    public ResponseEntity errorBadRequest() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler({
            AccessDeniedException.class
    })
    public ResponseEntity accessDenied() {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new MsgError("Acesso negado"));
    }

//    @ExceptionHandler({
//            BadCredentialsException.class,
//            AuthorizationException.class
//    })
//    public ResponseEntity badCredentialsException() {
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("Credenciais incorretas."));
//    }
}