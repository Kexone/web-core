package com.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;


public class AbstractController implements Serializable {

    private static final Long serialVersionUID = 1L;

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<String> handleExceptionDefault(Exception e, HttpServletResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<>(handleException(e), headers, HttpStatus.BAD_REQUEST);
    }

    private String handleException(Exception ex) {
        return ex.getMessage() != null ? ex.getMessage() : ex.getCause().toString();
    }
}
