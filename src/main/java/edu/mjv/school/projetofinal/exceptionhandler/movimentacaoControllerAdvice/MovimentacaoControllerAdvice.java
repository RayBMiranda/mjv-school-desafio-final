package edu.mjv.school.projetofinal.exceptionhandler.movimentacaoControllerAdvice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mjv.school.projetofinal.exceptionhandler.MessageExceptionHandler;

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
	public ResponseEntity<MessageExceptionHandler> movimentacaoInternalServerErrorException(MovimentacaoInternalServerErrorException movimentacaoInternalServerErrorException){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Dado informado é inválido.");
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseBody
	@ExceptionHandler(MovimentacaoBadRequestException.class)
	public ResponseEntity<MessageExceptionHandler> movimentacaoBadRequest(MovimentacaoBadRequestException movimentacaoBadRequestException){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.BAD_REQUEST.value(), "Dado informado naõ pode ser tratado. Informe apenas números.");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
