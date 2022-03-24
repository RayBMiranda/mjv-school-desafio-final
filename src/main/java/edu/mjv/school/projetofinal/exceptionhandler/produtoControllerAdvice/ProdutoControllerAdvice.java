package edu.mjv.school.projetofinal.exceptionhandler.produtoControllerAdvice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mjv.school.projetofinal.exceptionhandler.MessageExceptionHandler;

@ControllerAdvice(basePackages = "edu.mjv.school.projetofinal.controller")
public class ProdutoControllerAdvice {

	@ResponseBody
	@ExceptionHandler(ProdutoNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> produtoNotFound(ProdutoNotFoundException produtoNotFound){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Produto não encontrado junto a Empresa do ID Informado.");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
