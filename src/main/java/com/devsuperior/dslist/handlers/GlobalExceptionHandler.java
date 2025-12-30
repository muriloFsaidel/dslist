package com.devsuperior.dslist.handlers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
   @ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorResponse> notFound() {
	   ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),"Id inválido, favor tentar novamente!");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(InvalidListException.class)
	public ErrorResponse invalidId(InvalidListException ex) {
		return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
	}
}
