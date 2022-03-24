package edu.mjv.school.projetofinal.exceptionhandler.categoriaControllerAdvice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mjv.school.projetofinal.exceptionhandler.MessageExceptionHandler;

@ControllerAdvice(basePackages = "edu.mjv.school.projetofinal.controller")
public class CategoriaControllerAdvice {

	@ResponseBody
	@ExceptionHandler(CategoriaNotFoundException.class)
	public ResponseEntity<MessageExceptionHandler> categoriaNotFound(CategoriaNotFoundException categoriaNotFoundException){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.NOT_FOUND.value(), "Categoria não encontrada.");
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ResponseBody
	@ExceptionHandler(CategoriaBadRequestException.class)
	public ResponseEntity<MessageExceptionHandler> categoriaBadRequest(CategoriaBadRequestException categoriaBadRequestException){
		MessageExceptionHandler error = new MessageExceptionHandler(new Date(), HttpStatus.BAD_REQUEST.value(), "Categoria informada naõ pode ser tratada. Informe apenas números.");
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
