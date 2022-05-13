package com.gregory.jogowarapi.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gregory.jogowarapi.services.exceptions.IllegalArgumentException;
import com.gregory.jogowarapi.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> illegalArgumentException(IllegalArgumentException ex,
			HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.CONFLICT.value(), "illegalArgumentException"
				, ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex,
			HttpServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found"
				, ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
