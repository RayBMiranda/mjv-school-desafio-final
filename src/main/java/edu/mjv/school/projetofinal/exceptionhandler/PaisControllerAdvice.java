package edu.mjv.school.projetofinal.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "edu.mjv.school.projetofinal.controller")
public class PaisControllerAdvice {

	@ResponseBody
	@ExceptionHandler(PaisNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> paisNotFound(PaisNotFoundException paisNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Pais não encontrado.");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(PaisInternalServerErrorException.class)
	public ResponseEntity<MessageExceptionHandler> paisBadRequest(PaisInternalServerErrorException paisInternalServerErrorException){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Dado informado é inválido.");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
