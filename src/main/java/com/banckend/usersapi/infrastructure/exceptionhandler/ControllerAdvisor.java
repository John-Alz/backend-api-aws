package com.banckend.usersapi.infrastructure.exceptionhandler;

import com.banckend.usersapi.infrastructure.exception.NoDataFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ExceptionRespnse> handleNoDataFoundException(NoDataFoundException e) {
        return ResponseEntity.badRequest().body(new ExceptionRespnse("Usuario no encontrado", LocalDateTime.now()));
    }

}
