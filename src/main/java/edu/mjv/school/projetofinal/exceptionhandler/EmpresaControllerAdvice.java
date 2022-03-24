package edu.mjv.school.projetofinal.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "edu.mjv.school.projetofinal.controller")
public class EmpresaControllerAdvice {

	@ResponseBody
	@ExceptionHandler(EmpresaNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> movimentacaoNotFound(EmpresaNotFoundException empresaNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Empresa não encontrado.");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(EmpresaInternalServerErrorException.class)
	public ResponseEntity<MessageExceptionHandler> EmpresaBadRequest(EmpresaInternalServerErrorException empresaInternalServerErrorException){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Dado informado é inválido.");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
