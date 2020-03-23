package com.retail.rest.myRetail.controller;

import com.retail.rest.myRetail.exception.NoRecordFoundException;
import com.retail.rest.myRetail.exception.RedSkySystemException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Illegal Argument";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value
            = { NoRecordFoundException.class})
    protected ResponseEntity<Object> handleNorecordFound(
            NoRecordFoundException ex, WebRequest request) {
        String bodyOfResponse = "NO RECORD FOUND";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NO_CONTENT, request);
    }

    @ExceptionHandler(value
            = { RedSkySystemException.class})
    protected ResponseEntity<Object> handleRedSkySystem(
            RedSkySystemException ex, WebRequest request) {
        String bodyOfResponse = "REDSKY SYSTEM NOT AVAILABLE";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
