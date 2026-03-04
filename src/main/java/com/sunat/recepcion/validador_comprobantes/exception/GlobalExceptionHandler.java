package com.sunat.recepcion.validador_comprobantes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> manejarRuntime(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("codigo", "404");
        error.put("mensaje", ex.getMessage());
        error.put("sistema", "SUNAT_VALIDATOR_V1");

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}