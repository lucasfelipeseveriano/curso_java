package com.softgraf.primavera.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProdutoNotFoundAdvice {

	@ResponseBody
	@ExceptionHandler(ProdutoNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String ProdutoNotFoundHandler(ProdutoNotFoundException ex) {
		return ex.getMessage();
	}
}
