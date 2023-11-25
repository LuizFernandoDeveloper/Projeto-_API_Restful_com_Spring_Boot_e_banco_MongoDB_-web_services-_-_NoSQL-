package com.luiz.mongodb.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luiz.mongodb.services.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;



@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseBody
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
	    HttpStatus status = HttpStatus.NOT_FOUND;
	    StandardError error  = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status)
	                         .header("Content-Type", "application/json") // Definir o tipo de mídia para JSON
	                         .body(error);
	}

}
