package com.myapp.bookmycab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler4(BadRequestException ie, WebRequest wr){
		MyErrorDetails err= new MyErrorDetails(LocalDateTime.now(),ie.getMessage(),wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err,HttpStatus.BAD_REQUEST);
	}

}
