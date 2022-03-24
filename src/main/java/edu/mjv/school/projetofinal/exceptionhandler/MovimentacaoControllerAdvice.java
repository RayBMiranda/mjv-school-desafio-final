package edu.mjv.school.projetofinal.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(basePackages = "edu.mjv.school.projetofinal.controller")
public class MovimentacaoControllerAdvice {

	@ResponseBody
	@ExceptionHandler(MovimentacaoNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> movimentacaoNotFound(MovimentacaoNotFoundException movimentacaoNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Movimentação não encontrada.");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(MovimentacaoInternalServerErrorException.class)
	public ResponseEntity<MessageExceptionHandler> movimentacaoBadRequest(MovimentacaoInternalServerErrorException movimentacaoInternalServerErrorException){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Dado informado é inválido.");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
